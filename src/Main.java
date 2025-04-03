import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static int NUMBER_OF_LINES = 51300;
    private static Random random = new Random();
    private static int RANDOM_LINE_NUM = random.nextInt(NUMBER_OF_LINES);
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        giveInstructions();
    }

    public static void giveInstructions () {
        System.out.println("Готов к игре? (Y)es/(N)o");
        String inputLine = scanner.nextLine().toLowerCase();
        switch (inputLine) {
            case "y":
                startGame();
                break;
            case "n":
                System.out.println("Жаль, ты крутой перец!");
                System.exit(0);
                break;
            default:
                break;
        }
    }

    public static void startGame() {
        String word = getRandomWord();
        String maskWord = makeMaskFromWord(word);
        int counter = 5;
        do {
            String symbol = scanner.nextLine();
            String newMaskWord = searchLetter(word, maskWord, symbol);
            counter += checkChanges(word, maskWord, newMaskWord);
            maskWord = newMaskWord;

            if (counter > 999) {
                System.out.println("Поздравляю! Ты выиграл! Твое слово - " + word);
                giveInstructions();
            }
            makeGameLogic(counter, word);
        } while (true);
    }
    public static void makeGameLogic(int counter, String word) {
        switch (counter) {
            case 4:
                System.out.println("--------\n|\n|\n|\n|\n/|");
                break;
            case 3:
                System.out.println("----|---\n|   o\n|\n|\n|\n/|");
                break;
            case 2:
                System.out.println("----|---\n|   o\n|   0\n|\n|\n/|");
                break;
            case 1:
                System.out.println("----|---\n|   o\n|  /0/\n|\n|\n/|");
                break;
            case 0:
                System.out.println("----|---\n|   o\n|  /0/\n|  //\n|\n/|");
                System.out.println("Ты проиграл... Загаданное слово было - " + word + "\n");
                giveInstructions();
                break;
            default: break;
        }
        System.out.println("Осталось " + counter + " шанс(а) угадать слово!");
    }

    public static int checkChanges (String word, String oldWord, String newWord) {
        if (newWord.equals(word)) {
            return 10000;
        } else if (oldWord.equals(newWord)) {
            return -1;
        } else {
            return 0;
        }
    }

    public static String searchLetter(String word, String maskWord, String symbol) {
        String[] words = word.split("");
        for (int i = 0; i < word.length(); i++) {
            if (Objects.equals(words[i], symbol)) {
                char[] maskWordChars = maskWord.toCharArray();
                maskWordChars[i] = symbol.charAt(0);
                maskWord = String.valueOf(maskWordChars);
            }
        }
        System.out.println(maskWord);
        return maskWord;
    }

    public static String makeMaskFromWord(String word) {
        String maskWord = "";
        for (int i = 0; i < word.length(); i++) {
            maskWord += "*";
        }
        System.out.println(maskWord);
        return maskWord;
    }


    public static String getRandomWord() {
        String word = "";
        try {
            FileReader readFile = new FileReader("dictionary.txt");
            BufferedReader readBuffer =  new BufferedReader(readFile);

            for (int lineNumber = 0; lineNumber <= RANDOM_LINE_NUM; lineNumber++) {
                if (lineNumber == RANDOM_LINE_NUM) {
                    word = readBuffer.readLine();
                } else {
                    readBuffer.readLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(word); // чтобы посмотреть отгадываемое слово
        return word;
    }
}