import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Generator {
    public static void main(String[] args) throws IOException {
            int[] arr = new int[10000];

            for (int j = 0; j < 10000; j++) {
                arr[j] = (int) (Math.random() * 10000);
            }

            writeToFile(arr);
    }

    public static void writeToFile(int[] array) throws IOException {

        File file = new File("Test.txt");
        file.createNewFile();
        FileWriter filewriter = new FileWriter(new File("Test.txt"));

        for (int j = 0; j < array.length; j++) {
            filewriter.write(array[j] + " ");
        }
        filewriter.flush();
    }
}
