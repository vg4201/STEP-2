import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FirstNonRepeatingCharacter {

    static Character findFirstNonRepeatingChar(String text) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char character : text.toCharArray()) {
            frequencyMap.put(character,
                    frequencyMap.getOrDefault(character, 0) + 1);
        }

        for (char character : text.toCharArray()) {
            if (frequencyMap.get(character) == 1) {
                return character;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a word or sentence: ");
        String text = scanner.nextLine();

        Character result = findFirstNonRepeatingChar(text);

        if (result != null) {
            System.out.println("First Non-Repeating Character: '"
                    + result + "'");
        } else {
            System.out.println("No Non-Repeating Character Found");
        }

        scanner.close();
    }
}