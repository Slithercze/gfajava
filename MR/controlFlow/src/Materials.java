import java.util.Scanner;

public class Materials {
    public static void main(String[] args) {
        int age = 31;
        System.out.println(age % 2 == 0);
        String result = null;
        for (int i = 0; i <= age; i++) {
            if (i == 15) {
                break;
            }
            System.out.println("Je mi " + i + " let");
            if (i % 2 == 0) {
                result = "Je to sude";
            } else {
                result = "Je to liche";
            }
            System.out.println(result);
        }
        System.out.println(result);
        System.out.println("-----------");
        System.out.println("while");
        System.out.println("-----------");
        int iteration = 0;
        boolean isEven = true;
        while (!isEven) {
            System.out.println(iteration += 2);
            iteration = iteration + 2;
            iteration++;
            isEven = iteration % 2 == 0;
        }
        System.out.println("---------");
        System.out.println("do while");
        System.out.println("---------");
        do {
            System.out.println(iteration);
            iteration++;
            isEven = iteration % 2 == 0;
        } while (!isEven);

        System.out.println("---If---");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        if (name == "Lukas") {
            System.out.println("ahoj kamo");
        } else if (name.equals("david")) {
            System.out.println("ffff");
        } else if (name == "ales") {
            System.out.println("bbbb");
        } else {
            System.out.println("neznam te");
        }
        System.out.println("---Switch---");
        switch (name) {
            case "Lukas":
                System.out.println("ahoj kamo");
                break;
            case "david":
                System.out.println("fffff");
                break;
            case "Ales":
                System.out.println("ddddd");
                break;
            default:
                System.out.println("neznam te");
                break;
        }
    }
}
