import java.util.ArrayList;
import java.util.List;

public class LineInfo {
    private List<Integer> digits;
    private List<String> words;

    public LineInfo() {
        this.digits = new ArrayList<>();
        this.words = new ArrayList<>();
    }

    public void addDigit(int digit) {
        digits.add(digit);
    }

    public void addWord(String word) {
        words.add(word);
    }

    public List<Integer> getDigits() {
        return digits;
    }

    public List<String> getWords() {
        return words;
    }

    public String convertWordToDigit() {
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            switch (word.toLowerCase()) {
                case "one" -> result.append("1");
                case "two" -> result.append("2");
                case "three" -> result.append("3");
                case "four" -> result.append("4");
                case "five" -> result.append("5");
                case "six" -> result.append("6");
                case "seven" -> result.append("7");
                case "eight" -> result.append("8");
                case "nine" -> result.append("9");
                default -> throw new IllegalArgumentException("Unexpected value: " + word);
            }
        }
        return result.toString();
    }

    @Override
    public String toString() {
        return "Digits: " + digits + "\nWords: " + words;
    }
}
