import java.util.Arrays;
import java.util.Scanner;

public class PlacementRankingEngine {

    static class Candidate implements Comparable<Candidate> {
        private String name;
        private double cgpa;
        private int codingScore;

        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }

        static boolean isEligible(double cgpa) {
            return cgpa >= 7.5;
        }

        static boolean isEligible(double cgpa, int codingScore) {
            return cgpa >= 6.5 && codingScore >= 60;
        }

        double getCompositeScore() {
            return (cgpa * 10) + (codingScore * 0.5);
        }

        @Override
        public int compareTo(Candidate other) {
            return Double.compare(
                    other.getCompositeScore(),
                    this.getCompositeScore()
            );
        }

        String getName() {
            return name;
        }
    }

    static String shortlistAndRank(Candidate[] candidates) {
        int eligibleCount = 0;

        for (Candidate candidate : candidates) {
            if (Candidate.isEligible(candidate.cgpa) ||
                Candidate.isEligible(candidate.cgpa,
                        candidate.codingScore)) {
                eligibleCount++;
            }
        }

        Candidate[] shortlisted = new Candidate[eligibleCount];
        int index = 0;

        for (Candidate candidate : candidates) {
            if (Candidate.isEligible(candidate.cgpa) ||
                Candidate.isEligible(candidate.cgpa,
                        candidate.codingScore)) {
                shortlisted[index] = candidate;
                index++;
            }
        }

        Arrays.sort(shortlisted);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < shortlisted.length; i++) {
            result.append(i + 1)
                    .append(". ")
                    .append(shortlisted[i].getName())
                    .append(" (")
                    .append(String.format("%.1f",
                            shortlisted[i].getCompositeScore()))
                    .append(")");

            if (i < shortlisted.length - 1) {
                result.append(" | ");
            }
        }

        if (shortlisted.length == 0) {
            return "No candidates shortlisted";
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of candidates: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        Candidate[] candidates = new Candidate[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nCandidate " + (i + 1));

            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            System.out.print("Enter CGPA: ");
            double cgpa = scanner.nextDouble();

            System.out.print("Enter coding score: ");
            int codingScore = scanner.nextInt();
            scanner.nextLine();

            candidates[i] = new Candidate(name, cgpa, codingScore);
        }

        System.out.println("\nShortlist and Ranking:");
        System.out.println(shortlistAndRank(candidates));

        scanner.close();
    }
}