import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class App {
    private static final Map<String, Set<String>> index = new HashMap<>();

    public static void main(String[] args) {
        loadDocuments();

        while (true) {
            System.out.print("Enter a word to search (type 'exit' to quit): ");
            String query = System.console().readLine().toLowerCase();

            if (query.equals("exit")) {
                System.out.println("Exiting Mini Search Engine. Goodbye!");
                break;
            }

            if (index.containsKey(query)) {
                Set<String> documents = index.get(query);
                System.out.println("Documents containing the word '" + query + "':");
                for (String document : documents) {
                    System.out.println(document);
                }
            } else {
                System.out.println("Word not found in any document.");
            }
        }
    }

    private static void loadDocuments() {
        indexDocument("document1.txt");
        indexDocument("document2.txt");
        indexDocument("document3.txt");
    }

    private static void indexDocument(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().split("[\\s.,;:!?\"()\\[\\]{}-]+");

                for (String word : words) {
                    if (!index.containsKey(word)) { // if the word is not present in the index, it proceeds to the next
                                                    // step.
                        index.put(word, new HashSet<>());
                    }

                    index.get(word).add(filename);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + filename);
            e.printStackTrace();
        }
    }
}
