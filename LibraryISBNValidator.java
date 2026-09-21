import java.util.Scanner;

public class LibraryISBNValidator {

    static String normalizeCode(String raw) {
        String code = raw.trim();

        if (code.length() < 3) {
            return code.toUpperCase();
        }

        String publisherCode = code.substring(0, 3).toUpperCase();
        String remainingPart = code.substring(3);

        return publisherCode + remainingPart;
    }

    static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: code must contain exactly 13 characters";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        for (int i = 3; i < code.length(); i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: code body must contain only digits";
            }
        }

        String publisherCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalogNumber = code.substring(7, 13);

        StringBuilder formattedResult = new StringBuilder();

        formattedResult.append("[")
                .append(publisherCode)
                .append("] YEAR: ")
                .append(year)
                .append(" | CATALOG: ")
                .append(catalogNumber);

        return formattedResult.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter ISBN-style code: ");
        String rawCode = scanner.nextLine();

        String normalizedCode = normalizeCode(rawCode);
        String result = validateAndFormat(normalizedCode);

        System.out.println(result);

        scanner.close();
    }
}