public class ElementaryOperations {

    // ONLY WORKS WITH INTEGERS SO FAR
    public static int add(int num1, int num2){
        int sum = 0;
        int carry = 0;
        if(num2 == 0){
            return num1;
        }
        sum = num1^num2;
        carry = (num1&num2)<<1;
        return add(sum, carry);
    }
    public static int multiply(int num1,int num2){
        int result = 0;
        while(num2 != 0){
            result = add(result,num1);
            num2 = subtract(num2, num1);
        }
        return result;
    }
    public static int divide(int num1, int num2){
        if(num2 > num1){
            return 0;
        }else if(num2==1){
            return 1;
        }
        int count = 0;
        while(num1 - num2 >=0){
            count = add(count, 1);
            num1 = subtract(num1, num2);
        }
        return count;
    }
    public static int subtract(int num1, int num2){
        while(num2 != 0){
            int borrow = (~num1) & num2;
            num1 ^= num2;
            num2 = borrow << 1;
        }
        return num1;
    }
}
