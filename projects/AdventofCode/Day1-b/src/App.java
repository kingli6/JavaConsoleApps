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
            processLine(line, numberWords);
            System.out.println(); // Add a newline for better readability
        }
    }

    public static void processLine(String input, Map<String, Integer> numberWords) {
        // Variables to store digit and word information
        int digitIndex = -1;
        int wordIndex = -1;

        for (int i = 0; i < input.length(); i++) {
            // Check for digits 1-9
            if (Character.isDigit(input.charAt(i))) {
                int digit = Character.getNumericValue(input.charAt(i));
                digitIndex = i;
                System.out.println("Digit: " + digit + " at index: " + digitIndex);
            }
            // Check for number words one-nine
            else {
                for (String wordKey : numberWords.keySet()) {
                    int endIndex = i + numberWords.get(wordKey);
                    if (endIndex <= input.length()
                            && input.regionMatches(true, i, wordKey, 0, numberWords.get(wordKey))) {
                        wordIndex = i;
                        System.out.println("Word: " + wordKey + " starting at index: " + wordIndex);
                        break; // Break to avoid overlapping matches
                    }
                }
            }
        }
    }
}
