import java.util.HashSet;
import java.util.Scanner;

public class InputReader
{
    private Scanner reader;
    private String lastInputLine; 

    public InputReader()
    {
        reader = new Scanner(System.in);
    }

    /**
     * Membaca input dari terminal dan mengembalikan set kata.
     * Juga menyimpan input asli dalam variabel lastInputLine.
     */
    public HashSet<String> getInput() 
    {
        System.out.print("> ");
        lastInputLine = reader.nextLine().trim().toLowerCase();

        String[] wordArray = lastInputLine.split(" ");
        HashSet<String> words = new HashSet<>();
        for(String word : wordArray) {
            words.add(word);
        }
        return words;
    }

    public String getLastInputLine() {
        return lastInputLine;
    }
}
