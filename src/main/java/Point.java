import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Entity(name="Point")
@Table(name="POINTS")
public class Point {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private double x;
    private BigDecimal y;
    private double r = 1;
    private boolean result;
    private LocalDateTime reqTime;

    public boolean calculate(){
        BigDecimal bigX = new BigDecimal(x);
        BigDecimal bigR = new BigDecimal(r);
        if (bigX.compareTo(BigDecimal.ZERO) <= 0 && bigX.compareTo(bigR.negate()) >= 0
                && y.compareTo(BigDecimal.ZERO) >= 0 && y.compareTo(bigR.divide(BigDecimal.valueOf(2))) <= 0) {
            return true;
        }
        if (bigX.compareTo(BigDecimal.ZERO) <= 0 && y.compareTo(BigDecimal.ZERO) <= 0
                && (bigX.pow(2).add(y.pow(2))).compareTo(bigR.pow(2)) <= 0) {
            return true;
        }
        if (bigX.compareTo(BigDecimal.ZERO) >= 0 && y.compareTo(BigDecimal.ZERO) <= 0
                && y.compareTo(bigX.subtract(bigR.divide(BigDecimal.valueOf(2)))) >= 0) {
            return true;
        }
        return false;
    }

    public double getX() {
        return x;
    }

    public BigDecimal getY() {
        return y;
    }

    public double getR() {
        return r;
    }

    public boolean isResult() {
        return result;
    }

    public String getReqTime() {
        return reqTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM, FormatStyle.MEDIUM));
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(BigDecimal y) {
        this.y = y;
    }

    public void setR(double r) {
        this.r = r;
    }

    public void setReqTime(LocalDateTime reqTime) {
        this.reqTime = reqTime;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
