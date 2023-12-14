import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        String text = """
                two1nine
                eightwothree
                abcone2threexyz
                xtwone3four
                4nineeightseven2
                zoneight234
                7pqrstsixteen
                """;

        String[] lines = text.split("\\R");

        // Define a map for number words and their corresponding lengths
        Map<String, Integer> numberWords = new HashMap<>();
        numberWords.put("one", 3);
        numberWords.put("two", 3);
        numberWords.put("three", 5);
        numberWords.put("four", 4);
        numberWords.put("five", 4);
        numberWords.put("six", 3);
        numberWords.put("seven", 5);
        numberWords.put("eight", 5);
        numberWords.put("nine", 4);

        // Process each line
        for (String line : lines) {
            System.out.println("Line: " + line);
            LineInfo lineInfo = processLine(line, numberWords);
            System.out.println(lineInfo);
            System.out.println("Converted Digit: " + lineInfo.convertWordToDigit());
            System.out.println(); // Add a newline for better readability
        }
    }

    public static LineInfo processLine(String input, Map<String, Integer> numberWords) {
        LineInfo lineInfo = new LineInfo();

        for (int i = 0; i < input.length(); i++) {
            // Check for digits 1-9
            if (Character.isDigit(input.charAt(i))) {
                int digit = Character.getNumericValue(input.charAt(i));
                lineInfo.addDigit(digit, i);
            }
            // Check for number words one-nine
            else {
                for (String word : numberWords.keySet()) {
                    int endIndex = i + numberWords.get(word);
                    if (endIndex <= input.length()
                            && input.regionMatches(true, i, word, 0, numberWords.get(word))) {
                        lineInfo.addWord(word, i);
                        break; // Break to avoid overlapping matches
                    }
                }
            }
        }

        return lineInfo;
    }
}
