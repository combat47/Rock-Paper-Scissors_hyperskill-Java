package rockpaperscissors;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String shape;
        boolean loopCondition = true;
        while (loopCondition) {
            shape = scanner.next();
            loopCondition = checkInputString(shape);
        }
    }

    private static boolean checkInputString(String shape) {
        if (shape.equals("rock") || shape.equals("paper") || shape.equals("scissors")) {
            System.out.println(takeDecisionByComputer(shape));
            return true;
        } else if (shape.equals("!exit")) {
            System.out.println("Bye!");
            return false;
        } else {
            System.out.println("Invalid input");
            return true;
        }
    }

    private static String takeDecisionByComputer(String shape) {
        Random random = new Random();
        int decision = random.nextInt(3);
        String computerDecision = switch (decision) {
            case 0 -> "rock";
            case 1 -> "paper";
            case 2 -> "scissors";
            default -> throw new IllegalStateException("Unexpected value: " + decision);
        };

        if (shape.equals("rock") && computerDecision.equals("paper") ||
                shape.equals("paper") && computerDecision.equals("scissors") ||
                shape.equals("scissors") && computerDecision.equals("rock") ) {
            return String.format("Sorry, but the computer chose %s", computerDecision);
        } else if (shape.equals(computerDecision)) {
            return String.format("There is a draw (%s)", computerDecision);
        } else  {
            return String.format("Well done. The computer chose %s and failed", computerDecision);
        }

    }
}
