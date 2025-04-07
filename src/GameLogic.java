import java.util.Scanner;

public class GameLogic {
    private final Scanner scanner = new Scanner(System.in);
    static RandomWord randomWord = new RandomWord();
    VerificationMethods verificationMethods = new VerificationMethods();

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
        String word = randomWord.getRandomWord();
        String maskWord = verificationMethods.makeMaskFromWord(word);
        int counter = 5;

        while (true) {
            char symbol = scanner.nextLine().toLowerCase().charAt(0);
            String newMaskWord = verificationMethods.searchLetter(word, maskWord, symbol);
            counter += verificationMethods.checkChanges(word, maskWord, newMaskWord);
            maskWord = newMaskWord;

            if (counter > 999) {
                System.out.println(GameConstants.CONGRATULATION + word);
                giveInstructions();
            }
            drawInTerminal(counter, word);
        }
    }
    public void drawInTerminal (int counter, String word) {
        switch (counter) {
            case 4:
                System.out.println(GameConstants.FOUR_ATTEMPT_DRAWING);
                break;
            case 3:
                System.out.println(GameConstants.THREE_ATTEMPT_DRAWING);
                break;
            case 2:
                System.out.println(GameConstants.TWO_ATTEMPT_DRAWING);
                break;
            case 1:
                System.out.println(GameConstants.ONE_ATTEMPT_DRAWING);
                break;
            case 0:
                System.out.println(GameConstants.ZERO_ATTEMPT_DRAWING);
                System.out.println(GameConstants.LOSE_GAME + word + "\n");
                giveInstructions();
                break;
        }
        System.out.println("Осталось " + counter + " шанс(а) угадать слово!");
    }
}
