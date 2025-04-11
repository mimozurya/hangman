public enum HangmanState {
    ATTEMPT_0(
            """
                        ----|---
                        |   o
                        |  /0/
                        |  //
                        |
                        /|
                        """
    ),
    ATTEMPT_1(
            """
                        ----|---
                        |   o
                        |  /0/
                        |
                        |
                        /|
                        """
    ),
    ATTEMPT_2(
            """
                        ----|---
                        |   o
                        |   0
                        |
                        |
                        /|
                        """
    ),
    ATTEMPT_3(
            """
                        ----|---
                        |   o
                        |
                        |
                        |
                        /|
                        """
    ),
    ATTEMPT_4(
            """
                        --------
                        |
                        |
                        |
                        |
                        /|
                        """
    ),
    ATTEMPT_5("");

    private String drawing;

    HangmanState(String drawing) {
        this.drawing = drawing;
    }

    public String getDrawing() {
        return drawing;
    }
}
