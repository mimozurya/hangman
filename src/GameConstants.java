public class GameConstants {
    static final String READY_TO_GAME = "Готов к игре? (Y)es/(N)o";
    static final String END_GAME = "Жаль, ты крутой перец!";
    static final String CONGRATULATION = "Поздравляю! Ты выиграл! Твое слово - ";
    static final String LOSE_GAME = "Ты проиграл... Загаданное слово было - ";
    static final String FILE_PATH = "dictionary.txt";

    static final String FOUR_ATTEMPT_DRAWING = """
                        --------
                        |
                        |
                        |
                        |
                        /|
                        """;
    static final String THREE_ATTEMPT_DRAWING = """
                        ----|---
                        |   o
                        |
                        |
                        |
                        /|
                        """;
   static final String TWO_ATTEMPT_DRAWING = """
                        ----|---
                        |   o
                        |   0
                        |
                        |
                        /|
                        """;
   static final String ONE_ATTEMPT_DRAWING = """
                        ----|---
                        |   o
                        |  /0/
                        |
                        |
                        /|
                        """;
   static final String ZERO_ATTEMPT_DRAWING = """
                        ----|---
                        |   o
                        |  /0/
                        |  //
                        |
                        /|
                        """;
}
