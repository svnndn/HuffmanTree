import java.io.*;
import java.nio.charset.StandardCharsets;


public class Main {
    public static void main(String[] args) {
        HuffmanTree tree = new HuffmanTree();

        try {
            InputStream stream = new FileInputStream("data/Test.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(stream, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = reader.readLine()) != null) {
                String[] numbers_1 = line.split(" ");
                for (int i = 0; i < numbers_1.length; i++) {
                    int num = Integer.parseInt(numbers_1[i]);
                    tree.insert(num, tree.calculateFrequency(num));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}