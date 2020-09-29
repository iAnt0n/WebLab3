package controller;

import model.Point;
import org.primefaces.PrimeFaces;
import utils.PointDAO;
import utils.PointDAOImpl;
import utils.Validator;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class PointListBean implements Serializable {
    private Point point;
    private List<Point> pointList;

    @Inject
    @Named("utils.PointDAO")
    private PointDAO pointDAO;

    public PointListBean() {}

    @PostConstruct
    public void init(){
        point = new Point();
        pointList = new ArrayList<>(pointDAO.getPoints());
    }

    public void addPoint() {
        if (Validator.isValid(point.getX(), point.getY(), point.getR())) {
            point.setReqTime(LocalDateTime.now());
            point.setResult(point.calculate());
            pointList.add(point);
            pointDAO.insertPoint(point);
            pointList = pointDAO.getPoints();
            double r = point.getR();
//            PrimeFaces.current().ajax().addCallbackParam("x", point.getX());
//            PrimeFaces.current().ajax().addCallbackParam("y", point.getY());
//            PrimeFaces.current().ajax().addCallbackParam("r", point.getR());
//            PrimeFaces.current().ajax().addCallbackParam("res", point.isResult());
            point = new Point();
            point.setR(r);
        }
}


    public Point getPoint() {
        return point;
    }

    public void setPoint(Point currentPoint) {
        this.point = currentPoint;
    }

    public List<Point> getPointList() {
        return pointList;
    }

    public void setPointList(List<Point> pointList) {
        this.pointList = pointList;
    }

    public void setPointDAO(PointDAOImpl pointDAO) {
        this.pointDAO = pointDAO;
    }

    public PointDAO getPointDAO() {
        return pointDAO;
    }
}
