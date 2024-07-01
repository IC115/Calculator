import java.util.*;
import java.math.*;
public class QuadraticEquations {
    private static MathContext mc = new MathContext(16, RoundingMode.HALF_UP);
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigDecimal a = new BigDecimal(sc.nextLine());
        BigDecimal b = new BigDecimal(sc.nextLine());
        BigDecimal c = new BigDecimal(sc.nextLine());
        sc.close();
        
        System.out.println(solveQuadratic(a,b,c));
    }
    public static String solveQuadratic(BigDecimal a, BigDecimal b, BigDecimal c){

        BigDecimal discriminant = b.pow(2, mc).subtract(a.multiply(c.multiply(BigDecimal.valueOf(4), mc), mc));
        BigDecimal twoA = a.multiply(BigDecimal.TWO);
        BigDecimal sqrtDiscriminant;

        boolean complexSolution = false;
                
        if (discriminant.equals(discriminant.abs())) {
            sqrtDiscriminant = discriminant.sqrt(mc);
        }else{
            sqrtDiscriminant = discriminant.negate(mc).sqrt(mc);
            complexSolution = true;
        }

        if(a.equals(BigDecimal.ZERO)){
            if (!b.equals(BigDecimal.ZERO)) {
                if (!c.equals(BigDecimal.ZERO)) {
                    // We use x = -c/b instead of quadratic formula 
                    return "x = " + c.negate().divide(b);  
                }
                // Only b is non-zero
                return "x = 0";
            }
            // a and b are zero meaning that c has to be zero to satisfy the equation
            if (c.equals(BigDecimal.ZERO)) {
                return "Infinite solutions";
            }
            return "Invalid equation: No value of x will satisfy the equation";
        }else if(b.equals(BigDecimal.ZERO)){
            if (c.equals(BigDecimal.ZERO)) {
                // Our equation is in the form ax^2 = 0
                return "x = 0";
            }else if (c.compareTo(BigDecimal.ZERO) < 0 ^ a.compareTo(BigDecimal.ZERO) < 0) {
                // Either a or c are positive 
                return "x = +/- " + c.divide(a).sqrt(mc);
            }else {
                // a and c are both either positive or negative
                return "x = +/- " + c.divide(a).abs().sqrt(mc) + "i";
            }
        }else if (c.equals(BigDecimal.ZERO)) {
            // Equation is in the form ax^2 + bx = 0
            // Factor out x to get x(ax + b) = 0
            // x is either 0 or -b/a
            return "x = 0 or " + b.negate().divide(a);
        }

        if (b.remainder(twoA).equals(BigDecimal.ZERO)) {
            b = b.divide(twoA);
            if (sqrtDiscriminant.remainder(twoA).equals(BigDecimal.ZERO)) {
                sqrtDiscriminant = sqrtDiscriminant.divide(twoA);
                if(!complexSolution){
                    if (sqrtDiscriminant.equals(BigDecimal.ZERO)) {
                        // Only one solution if the discriminant is 0
                        return "x = " + b.negate();
                    }
                    return "x = " + b.negate() + " +/- " + sqrtDiscriminant;
                }else{
                    if (sqrtDiscriminant.equals(BigDecimal.ZERO)) {
                        return "x = " + b.negate();
                    }
                    return "x = " + b.negate() + " +/- " + sqrtDiscriminant + "i";
                }
            }else{
                if(!complexSolution){
                    if (sqrtDiscriminant.equals(BigDecimal.ZERO)) {
                        return "x = " + b.negate();
                    }
                    return "x = " + b.negate() + " +/- " + sqrtDiscriminant;
                }else{
                    if (sqrtDiscriminant.equals(BigDecimal.ZERO)) {
                        return "x = " + b.negate();
                    }
                    return "x = " + b.negate() + " +/- " + sqrtDiscriminant + "i";
                }
            }
        }else if (sqrtDiscriminant.remainder(twoA).equals(BigDecimal.ZERO)) {
            sqrtDiscriminant = sqrtDiscriminant.divide(twoA);

            if(!complexSolution){
                return "x = " + b.negate() + " +/- " + sqrtDiscriminant;
            }else{
                return "x = " + b.negate() + " +/- " + sqrtDiscriminant + "i";
            }
        }else if (!complexSolution) {
            return "x = (" + b.negate() + " +/- " + sqrtDiscriminant + ") / " + a.multiply(BigDecimal.TWO, mc);
        }else{
            return "x = (" + b.negate() + " +/- " + sqrtDiscriminant + "i) / " + a.multiply(BigDecimal.TWO, mc);
        }
    }
}