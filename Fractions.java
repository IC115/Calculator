import java.math.*;
import java.util.*;

public class Fractions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigDecimal bigD = new BigDecimal(sc.nextLine());
        BigDecimal bigD2 = new BigDecimal(sc.nextLine());
        sc.close();
        System.out.println(simplestForm(bigD, bigD2));
    }
    public static String simplestForm(BigDecimal numerator, BigDecimal denominator){
        if(denominator.equals(BigDecimal.ZERO)){
            return "NaN";
        }else if(numerator.equals(BigDecimal.ZERO)){
            return "0";
        }

        BigDecimal gcd = GCD(numerator, denominator);
        BigDecimal numByGCD = numerator.divide(gcd);
        BigDecimal denByGCD = denominator.divide(gcd);
        
        if (denByGCD.equals(BigDecimal.ONE)) {
            return numByGCD + "";
        }

        return numByGCD + "/" + denByGCD;
    }

    public static BigDecimal GCD(BigDecimal num1, BigDecimal num2){
        // Check if we should have a negative sign in our output
        boolean negativeSign = false;
        
        if(num1.equals(num1.abs()) ^ num2.equals(num2.abs())){
            negativeSign = true;
        }

        // Ignore the sign
        num1 = num1.abs();
        num2 = num2.abs();

        // Finding the GCD
        while (!num1.equals(num2)) {
            if (num1.compareTo(num2) == 1) {
                num1 = num1.remainder(num2);
                if(num1.compareTo(BigDecimal.ZERO) == 0 && negativeSign){
                    return num2.negate();
                }else if (num1.compareTo(BigDecimal.ZERO) == 0 && !negativeSign) {
                    return num2;
                }
            } else {
                num2 = num2.remainder(num1);
                if(num2.compareTo(BigDecimal.ZERO) == 0 && negativeSign){
                    return num1.negate();
                }else if (num2.compareTo(BigDecimal.ZERO) == 0 && !negativeSign) {
                    return num1;
                }
            }
        }
        return num1;
    }
}