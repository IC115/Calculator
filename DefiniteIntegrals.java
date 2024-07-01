public class DefiniteIntegrals {
    public static double trapeziumRule(double lowerBound, double upperBound, int n){
        double delta = (upperBound-lowerBound)/n;
        double sum = 0.5 * (f(upperBound) + f(lowerBound));

        for(int i=1; i<n; i++){
            double x = lowerBound + delta*i;
            sum += f(x);
        }
        return sum*delta;
    }
    public static double simpsonsRule(double lowerBound, double upperBound, int n){
        double delta = (upperBound-lowerBound)/(n);
        double sum = (f(lowerBound) + f(upperBound));

        for(int i=1; i<n; i++){
            double x = lowerBound + delta*i;
            if (i%2 == 0) {
                sum += 2*f(x);
            }else{
                sum += 4*f(x);
            }
        }
        return sum * (delta/3);
    }
    public static double midpointRule(double lowerBound, double upperBound, int n){
        double delta = (upperBound-lowerBound)/n;
        double sum = 0.0;
        for(int i=0; i<n; i++){
            double x = lowerBound + delta*(i+0.5);
            sum += f(x);
        }
        return sum*delta;
    }
    public static double leftHandRule(double lowerBound, double upperBound, int n){
        double delta = (upperBound-lowerBound)/n;
        double sum = 0.0;
        for(int i=0; i<n; i++){
            double x = lowerBound + delta*i;
            sum += f(x);
        }
        return sum*delta;
    }
    public static double rightHandRule(double lowerBound, double upperBound, int n){
        double delta = (upperBound-lowerBound)/n;
        double sum = 0.00;
        for(int i=1; i<n+1; i++){
            double x = lowerBound + delta*i;
            sum += f(x);
        }
        return sum*delta;
    }
    public static double f(double x){
        return Math.exp(-x*x);
    }
}