import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class FilteredWordFrequency {

    static void printFilteredWordFrequency(String feedback) {
        Set<String> stopWords = new HashSet<>();

        stopWords.add("the");
        stopWords.add("was");
        stopWords.add("and");
        stopWords.add("a");
        stopWords.add("is");
        stopWords.add("of");
        stopWords.add("in");

        String cleanedText = feedback.toLowerCase();

        cleanedText = cleanedText.replace(".", "");
        cleanedText = cleanedText.replace(",", "");
        cleanedText = cleanedText.replace("!", "");
        cleanedText = cleanedText.replace("?", "");

        String[] words = cleanedText.split("\\s+");

        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String word : words) {
            if (!stopWords.contains(word)) {
                frequencyMap.put(word,
                        frequencyMap.getOrDefault(word, 0) + 1);
            }
        }

        List<Map.Entry<String, Integer>> entries =
                new ArrayList<>(frequencyMap.entrySet());

        entries.sort((entry1, entry2) ->
                entry2.getValue() - entry1.getValue());

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": "
                    + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter feedback text:");
        String feedback = scanner.nextLine();

        System.out.println("\nFiltered Word Frequency Report:");
        printFilteredWordFrequency(feedback);

        scanner.close();
    }
}