package rockpaperscissors;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String userInput = scanner.next();
        String[] names = {"paper","scissors","rock"};
        Random random = new Random();
        int a = random.nextInt(names.length);
        String computerChoice = names[a];

        switch (userInput) {
            case "paper" -> {
                if (names[a].equals("rock")) {
                    System.out.printf("Well done. The computer chose %s and failed", computerChoice);
                } else if (names[a].equals("scissors")) {
                    System.out.printf("Sorry, but the computer chose %s", computerChoice);
                } else if (names[a].equals("paper")) {
                    System.out.printf("There is a draw (%s)", computerChoice);
                }
            }
            case "scissors" -> {
                if (names[a].equals("paper")) {
                    System.out.printf("Well done. The computer chose %s and failed", computerChoice);
                } else if (names[a].equals("rock")) {
                    System.out.printf("Sorry, but the computer chose %s", computerChoice);
                } else if (names[a].equals("scissors")) {
                    System.out.printf("There is a draw (%s)", computerChoice);
                }
            }
            case "rock" -> {
                if (names[a].equals("scissors")) {
                    System.out.printf("Well done. The computer chose %s and failed", computerChoice);
                } else if (names[a].equals("paper")) {
                    System.out.printf("Sorry, but the computer chose %s", computerChoice);
                } else if (names[a].equals("rock")) {
                    System.out.printf("There is a draw (%s)", computerChoice);
                }
            }
        }
    }
}
