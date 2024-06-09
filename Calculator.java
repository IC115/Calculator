import java.math.*;
import java.util.*;

public class Calculator extends ElementaryOperations{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //double inp = sc.nextDouble();
        String input = sc.nextLine();
        // String input = sc.nextLine();
        // switch (input.toLowerCase()) {
        //     case "e" -> inp = Math.E;
        //     case "pi" -> inp = Math.PI;
        //     case input.toLowerCase().matches("^sqrt.*[\\(\\)]") ->
        //     inp = Math.sqrt(Double.parseDouble((input.replace("sqrt","")).substring(1,(input.replace("sqrt","")).length()-1)));
        //     }
        // inp = Math.sqrt(Double.parseDouble((input.replace("sqrt","")).substring(1,(input.replace("sqrt","")).length()-1)));
        // System.out.print(inp);
        
        //System.out.println( Math.sqrt(Double.parseDouble((input.replace("sqrt","")).substring(1,(input.replace("sqrt","")).length()-1))));;
        // ^ ABOVE CODE TAKES IN A STRING AND IF ITS IN THE FORM OF sqrt(num) THEN IT RETURNS NUM AS A DOUBLE
        // double n = sc.nextDouble();
        // double m = sc.nextDouble();
        // fracSimplifier(n, m);
        
        //System.out.println(doubleToBinaryString(inp));
        fracSimplifier(8, 3);
    }

    public static void fracSimplifier(double n, double m)
    {
        long nLong = toLong(n);
        long mLong = toLong(m);
        boolean simplestForm = false;

        if(nLong/n >= mLong/m) {                // checks which number has to be multiplied by a greater power of 10 to get rid of it's decimals
            mLong = Math.round(m*(nLong)/n);    // and multiplies both by the bigger power of 10
        }                                       
        else {                                  
            nLong = Math.round(n*(mLong)/m);    
        }

        if (n==0) {
            System.out.println(0);
        }
        else if (m==0) {
            System.out.println("Division by 0, NaN");
        }
        else if (m>=n) {
            for(long i=nLong; i>=2; i--) { // we set i to be n as the greatest possible common factor of two numbers can be the smaller of the two numbers
            if(nLong%i==0 && mLong%i==0) {    // check if i is a factor of n and m
                if(mLong/i==1) {          // if i is a factor of both numbers AND the denomintor equals 1 after dividing by i
                    simplestForm = true;     // our simplest form is n/i 
                    System.out.println(nLong/i);
                    break;
                }
                simplestForm = true;    // when m/i != 1 our simplest form is a fraction
                System.out.println(nLong/i + "/" + mLong/i + " = " + (n/i)/(m/i));  
                break;
                }
            }
            if (!simplestForm) {        // only runs when n and m  have NO common factors ie the fraction is
                System.out.println(nLong + "/" + mLong + " = " + n/m);     // already in it's simplest form
            }
        }
        else {
            for(long j=mLong; j>=2; j--) {
            if(nLong%j==0 && mLong%j==0) {
                if(mLong/j==1) {
                    simplestForm = true;
                    System.out.println(nLong/j);
                    break;
                }
                simplestForm = true;
                System.out.println(nLong/j + "/" + mLong/j + " = " + (n/j)/(m/j));
                break;
                }
            }
            if (!simplestForm) {
                System.out.println(nLong + "/" + mLong + " = " + n/m);
            }
        }
    }
    public static long toLong(double num)
    {
        long number;
        if ((Double.toString(num)).substring(Double.toString(num).indexOf('.')).matches("^.0+$")) { // if theres only zeros after decimal point cast into a long
            number =  (long) num;
        }
        else {
            int decPlaces = (Double.toString(num)).substring(Double.toString(num).indexOf('.')).length()-1; // gets the number of places after decimal point
            number = (long) (num*(Math.pow(10, decPlaces)));   // multiplies the number by 10^decPlaces to get rid of decimals and casts it into a long 
        }
        return number;
    }
    public static String convertToBinary(double number) {
        int i=1;
        String num="";
        double temp = 0;
        int noofbits=32;
        while (i<=noofbits && number>0) {
            number=number*2;
            temp=Math.floor(number);
            num+=(int)temp;
            number=number-temp;
            i++;
        }
        return num;
    }
    public static String doubleToBinaryString(double dbl) {
        String s = getDoubleAsHexString(dbl);
        return new BigInteger(s, 16).toString(2);
    }
    public static String getDoubleAsHexString(double input) {
        long doubleAsLong = Double.doubleToRawLongBits(input);
        return Long.toHexString(doubleAsLong);
      }
}