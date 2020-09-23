import java.math.BigDecimal;
import java.util.Date;

public class Point {
    private double x;
    private BigDecimal y;
    private double r = 1;
    private boolean result;
    private Date reqTime;
    private long compTime;

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

    public Date getReqTime() {
        return reqTime;
    }

    public long getCompTime() {
        return compTime;
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

    public void setReqTime(Date reqTime) {
        this.reqTime = reqTime;
    }

    public void setCompTime(long compTime) {
        this.compTime = compTime;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
