import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class WordGenerator {

    public String getRandomWord() {
        int NUMBER_OF_LINES = searchNumberOfLines();
        Random random = new Random();
        int randomLineNumber = random.nextInt(NUMBER_OF_LINES);

        String word = "";
        try (BufferedReader readBuffer = new BufferedReader(new FileReader(GameConstants.FILE_PATH))) {
            for (int lineNumber = 0; lineNumber <= randomLineNumber; lineNumber++) {
                if (lineNumber == randomLineNumber) {
                    word = readBuffer.readLine();
                } else {
                    readBuffer.readLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return word;
    }

    private int searchNumberOfLines() {
        int count = 0;
        try (BufferedReader readBuffer = new BufferedReader(new FileReader(GameConstants.FILE_PATH))) {
            while (readBuffer.readLine() != null) {
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }
}
