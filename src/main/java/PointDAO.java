import java.util.List;

public interface PointDAO {
    void insertPoint(Point point);
    List<Point> getPoints();
}
