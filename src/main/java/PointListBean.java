import org.primefaces.PrimeFaces;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Named
@SessionScoped
public class PointListBean implements Serializable {
    private Point point;
    private List<Point> pointList;

    @Inject
    private PointDAOImpl pointDAOImpl;

    public PointListBean() {}

    @PostConstruct
    public void init(){
        point = new Point();
        pointList = new ArrayList<>(pointDAOImpl.getPoints());
    }

    public void addPoint() {
        point.setReqTime(LocalDateTime.now());
        point.setResult(point.calculate());
        pointList.add(point);
        pointDAOImpl.insertPoint(point);
        double r = point.getR();
        PrimeFaces.current().ajax().addCallbackParam("x", point.getX());
        PrimeFaces.current().ajax().addCallbackParam("y", point.getY());
        PrimeFaces.current().ajax().addCallbackParam("r", point.getR());
        PrimeFaces.current().ajax().addCallbackParam("res", point.isResult());;
        point = new Point();
        point.setR(r);
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

    public void setPointDAOImpl(PointDAOImpl pointDAOImpl) {
        this.pointDAOImpl = pointDAOImpl;
    }

    public PointDAOImpl getPointDAOImpl() {
        return pointDAOImpl;
    }
}
