import java.util.ArrayList;
import java.util.List;

public class LineInfo {
    private List<Integer> digits;
    private List<String> words;
    private List<Integer> digitIndices;
    private List<Integer> wordIndices;

    public LineInfo() {
        this.digits = new ArrayList<>();
        this.words = new ArrayList<>();
        this.digitIndices = new ArrayList<>();
        this.wordIndices = new ArrayList<>();
    }

    public void addDigit(int digit, int index) {
        digits.add(digit);
        digitIndices.add(index);
    }

    public void addWord(String word, int index) {
        words.add(word);
        wordIndices.add(index);
    }

    public List<Integer> getDigits() {
        return digits;
    }

    public List<String> getWords() {
        return words;
    }

    public List<Integer> getDigitIndices() {
        return digitIndices;
    }

    public List<Integer> getWordIndices() {
        return wordIndices;
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
        return "Digits: " + digits + "\nWords: " + words + "\nDigit Indices: " + digitIndices + "\nWord Indices: "
                + wordIndices;
    }
}
