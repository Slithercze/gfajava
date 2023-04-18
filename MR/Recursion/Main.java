import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        //base case
        //stack
        //fib
        //exception ☠️
        //fractal?

        //System.out.println(fib(48));
        //System.out.println(fibCycle(1000000).toString().length());

        byte b = 127;
        System.out.println((byte) (b + 1)); // -128

        try {
            fib(-2);
        } catch (Exception e) {
            System.err.println("Exception handled: " + e.getMessage());
        }
    }

    static BigDecimal fibCycle(int index) {
        BigDecimal tmp = new BigDecimal(0);
        BigDecimal a = new BigDecimal(0);
        BigDecimal b = new BigDecimal(1);

        for (int i = 0; i < index; i++) {
            tmp = a.add(b);
            a = b;
            b = tmp;
        }

        return a;
    }
    static long fib(int index) throws Exception {
        if (index < 0) {
            throw new Exception("can't compute, index must be positive number!");
        }

        if (index < 2) return index;

        return fib(index - 1) + fib(index - 2);
    }
}