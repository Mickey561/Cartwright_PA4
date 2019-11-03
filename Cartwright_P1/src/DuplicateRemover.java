import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

public class DuplicateRemover {
        HashSet<String> uniqueWords;

        DuplicateRemover ()
        {
            uniqueWords = new HashSet<String>();
        }

        public void remove(String dataFile) {
            File file = new File(dataFile);

            try (Scanner read = new Scanner(file)) {
                while (read.hasNext()) {
                    uniqueWords.add(read.next().toLowerCase());
                }
            } catch (IOException e) {
                System.out.println("You have encountered an IO exception.");
            }
        }

        public void write(String outputFile)
        {
            File file = new File(outputFile);
            try (PrintWriter out = new PrintWriter(file)) {
                for(String word : uniqueWords)
                {
                    out.println(word);
                }
            } catch (IOException e) {
                System.out.println("You have encountered an IO exception.");
            }
        }
}