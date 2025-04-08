import java.util.Scanner;

public class GameLogic {
    private final Scanner scanner = new Scanner(System.in);
    static WordGenerator wordGenerator = new WordGenerator();
    Validator validator = new Validator();

    public void giveInstructions() {
        System.out.println(GameConstants.READY_TO_GAME);
        String inputLine = scanner.nextLine().toLowerCase();
        switch (inputLine) {
            case "y":
                startGame();
                break;
            case "n":
                System.out.println(GameConstants.END_GAME);
                System.exit(0);
                break;
        }
    }

    public void startGame() {
        String word = wordGenerator.getRandomWord();
        String maskWord = validator.getMaskFromWord(word);
        int counter = 5;

        while (true) {
            char symbol = scanner.nextLine().toLowerCase().charAt(0);
            String newMaskWord = validator.searchLetterAndGetItMask(word, maskWord, symbol);
            counter += validator.checkChanges(word, maskWord, newMaskWord);
            maskWord = newMaskWord;

            if (counter > 999) {
                System.out.println(GameConstants.CONGRATULATION + word);
                giveInstructions();
            }
            drawInTerminal(counter, word);
        }
    }
    public void drawInTerminal (int counter, String word) {
        HangmanState hangmanState = HangmanState.valueOf("ATTEMPT_"+counter);
        System.out.println(hangmanState.getDrawing());

        System.out.println("Осталось " + counter + " шанс(а) угадать слово!");
        if (counter == 0) {
            System.out.println(GameConstants.LOSE_GAME + word + "\n");
            giveInstructions();
        }
    }
}
