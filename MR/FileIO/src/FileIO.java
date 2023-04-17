import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileIO {
    public static void main(String[] args) {
        try {
            fileRead();
        } catch (IOException e){

        }

    }

    public static void fileRead() throws IOException{
        Path filePath = Paths.get("assets/names.txt");
        System.out.println(filePath);

//        try{
            List<String> names = Files.readAllLines(filePath);
//            for (int i = 0; i < names.size(); i++) {
//                System.out.println(names.get(i));
//            }
            for (String name: names) {
                System.out.println(name);
//            }
//        } catch (IOException ioException){
//            System.out.println("The file not found");
//        }
    }
}
