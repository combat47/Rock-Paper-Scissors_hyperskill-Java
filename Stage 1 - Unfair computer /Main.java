package rockpaperscissors;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.equals("paper")) {
            System.out.println("Sorry, but the computer chose scissors");
        } else if (input.equals("scissors")) {
            System.out.println("Sorry, but the computer chose rock");
        } else if (input.equals("rock")) {
            System.out.println("Sorry, but the computer chose paper");
        }
    }
}
