import java.math.BigDecimal;

public class Validator {
    public static boolean isValid(double x, BigDecimal y, double r){
        return Double.compare(x, -5)>0&&(Double.compare(x, 4.5)<0)
                &&(Double.compare(y.doubleValue(), -4.5)>0)&&Double.compare(y.doubleValue(), 4.5)<0
                &&(r==1||r==1.5||r==2||r==2.5||r==3||r==3.5||r==4);
    }
}
