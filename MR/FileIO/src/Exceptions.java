import java.nio.file.FileAlreadyExistsException;
import java.util.Scanner;

public class Exceptions {
    public static void main(String[] args) {
        int first = 5;
//        System.out.print("Give me a number: ");
//        Scanner scanner = new Scanner(System.in);
//        int second = scanner.nextInt();


        DivideNumbers(first, 0);
        try{
            DivideNumbers(2,5);
        } catch (ArithmeticException exception) {
//            System.out.println(exception);
        }
        System.out.println("Text after exception");

    }

    public static void DivideNumbers(int first, int second){
        if(first==1){
            throw new ArithmeticException("The fist number can't be one.");
        }
        if(second == 5){
            throw new ArithmeticException("The second number can't be five.");

        }
        try{
            System.out.println("Result of division is 5 / " + second + "=" + first / second);
        }catch(ArithmeticException exception) {
            System.out.println("The divisor is zero");
            throw new NullPointerException("asdf");
        } finally {
            System.out.println("Is always printed");
        }
    }
}
