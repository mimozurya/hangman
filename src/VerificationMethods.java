public class VerificationMethods {
    public int checkChanges (String word, String oldWord, String newWord) {
        if (newWord.equals(word)) {
            return 10000;
        } else if (oldWord.equals(newWord)) {
            return -1;
        } else {
            return 0;
        }
    }

    public String searchLetter(String word, String maskWord, char symbol) {
        char[] words = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            if (words[i] == symbol) {
                char[] maskWordChars = maskWord.toCharArray();
                maskWordChars[i] = symbol;
                maskWord = String.valueOf(maskWordChars);
            }
        }
        System.out.println(maskWord);
        return maskWord;
    }

    public String makeMaskFromWord(String word) {
        StringBuilder maskWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            maskWord.append("*");
        }
        System.out.println(maskWord);
        return maskWord.toString();
    }
}
