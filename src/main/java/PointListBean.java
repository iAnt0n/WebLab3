import org.primefaces.PrimeFaces;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PointListBean {
    private Point point;
    private List<Point> pointList;


    public PointListBean() {
        point = new Point();
        pointList = new ArrayList<>();
    }

    public void addPoint() {
        point.setReqTime(new Date());
        long start = System.nanoTime();
        point.setResult(point.calculate());
        point.setCompTime((System.nanoTime() - start) / 1000);
        pointList.add(point);
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

}
