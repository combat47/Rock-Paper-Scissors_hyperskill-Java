package rockpaperscissors;

import javax.annotation.processing.Filer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] choices = {"rock", "paper", "scissors"};
        System.out.print("Enter your name:");
        String name = scanner.nextLine();
        System.out.printf("Hello, %s%n", name);
        int score = 0;
        try {
            String fileContent = new String(Files.readAllBytes(Paths.get("rating.txt")));
            String[] names = fileContent.split("\n");
            for (String pair : names) {
                String[] p = pair.split(" ");
                if (p[0].equals(name)) score = Integer.parseInt(p[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        outer:
        while (true) {
            String userChoice = scanner.next();
            String computerChoice = choices[(int) (Math.random() * 3)];
            if (userChoice.equals(computerChoice)) {
                System.out.printf("There is a draw (%s)%n", userChoice);
                score += 50;
                continue;
            }
            switch (userChoice) {
                case "scissors" -> {

                    if (computerChoice.equals("rock"))
                        System.out.println("Sorry, but the computer chose rock");
                    else {
                        score += 100;
                        System.out.println("Well done. The computer chose paper and failed");
                    }
                }
                case "paper" -> {
                    if (computerChoice.equals("scissors"))
                        System.out.println("Sorry, but the computer chose scissors");
                    else {
                        score += 100;
                        System.out.println("Well done. The computer chose rock and failed");
                    }
                }
                case "rock" -> {
                    if (computerChoice.equals("paper"))
                        System.out.println("Sorry, but the computer chose paper");
                    else {
                        score += 100;
                        System.out.println("Well done. The computer chose scissors and failed");
                    }
                }
                case "!rating" -> System.out.println(score);
                case "!exit" -> {
                    System.out.println("Bye!");
                    break outer;
                }
                default -> System.out.println("Invalid input");
            }
        }
    }
}
