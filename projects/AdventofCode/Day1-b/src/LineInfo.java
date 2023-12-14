import java.util.Map;

public class LineInfo {
    private int digit;
    private int digitIndex;
    private String wordKey;
    private int wordIndex;

    // Constructor
    public LineInfo(int digit, int digitIndex, String wordKey, int wordIndex) {
        this.digit = digit;
        this.digitIndex = digitIndex;
        this.wordKey = wordKey;
        this.wordIndex = wordIndex;
    }

    // Getters
    public int getDigit() {
        return digit;
    }

    public int getDigitIndex() {
        return digitIndex;
    }

    public String getWordKey() {
        return wordKey;
    }

    public int getWordIndex() {
        return wordIndex;
    }

    // Convert word to digit and return the combined result
    public int convertWordToDigit() {
        Map<String, Integer> wordToDigitMap = Map.of(
                "one", 1,
                "two", 2,
                "three", 3,
                "four", 4,
                "five", 5,
                "six", 6,
                "seven", 7,
                "eight", 8,
                "nine", 9);

        if (wordKey != null) {
            return wordToDigitMap.getOrDefault(wordKey, -1);
        }

        return -1;
    }

    @Override
    public String toString() {
        return "Digit: " + digit + " at index: " + digitIndex +
                ", Word: " + wordKey + " starting at index: " + wordIndex;
    }
}
