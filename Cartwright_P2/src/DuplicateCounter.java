import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class DuplicateCounter {
    HashMap<String, Integer> wordNum;

    DuplicateCounter()
    {
        wordNum = new HashMap<String, Integer>();
    }

    public void count(String dataFile)
    {
        File file = new File(dataFile);
        try (Scanner read = new Scanner(file)) {
            while(read.hasNext())
            {
                String word = read.next().toLowerCase();
                int count = wordNum.getOrDefault(word, 0);
                wordNum.put(word, count + 1);
            }
        } catch (IOException e) {
            System.out.println("You have encountered an IO exception.");
        }
    }

    public void write(String outputFile)
    {
        File file = new File(outputFile);
        try (PrintWriter out = new PrintWriter(file)) {
            for (String word : wordNum.keySet()) {
                out.println(word + " - " + wordNum.get(word));
            }
        } catch (IOException e) {
            System.out.println("You have encountered an IO exception.");
        }
    }
}
