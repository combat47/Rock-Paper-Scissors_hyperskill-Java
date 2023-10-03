package rockpaperscissors;

import java.util.Scanner;
import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    private static final String pathToRatingFile = "rating.txt";

    private static int setInitialRating(String userName) {
        int userRating = 0;
        File file = new File(pathToRatingFile);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.startsWith(userName)) {
                    userRating = Integer.parseInt(line, userName.length() + 1, line.length(), 10);
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getClass().getName());
        }
        return userRating;
    }

    private static boolean isUserWin(int userIdx, int compIdx, int optionsSize) {
        int losingSteps = optionsSize / 2;
        int losingIdxBoundary = userIdx + losingSteps;
        if (losingIdxBoundary >= optionsSize) {
            return compIdx < userIdx && compIdx > losingIdxBoundary % optionsSize;
        } else {
            return compIdx < userIdx || compIdx > losingIdxBoundary;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter your name:");
            String username = scanner.nextLine();
            System.out.printf("Hello, %s\n", username);

            int userRating = setInitialRating(username);

            String optionsStr = scanner.nextLine();
            List<String> optionList;
            if ("".equals(optionsStr)) {
                optionList = Arrays.asList("rock", "paper", "scissors");
            } else {
                String[] optionsArray = optionsStr.split(",");
                optionList = Arrays.asList(optionsArray);
            }
            int optionsSize = optionList.size();

            Set<String> optionSet = new HashSet<String>(optionList);

            System.out.println("Okay, let's start");

            while (scanner.hasNextLine()) {
                String userInput = scanner.nextLine();
                if ("!rating".equals(userInput)) {
                    System.out.println(userRating);
                } else if ("!exit".equals(userInput)) {
                    System.out.println("Bye!");
                    return;
                } else if (optionSet.contains(userInput)) {
                    Random rand = new Random();
                    int compIdx = rand.nextInt(optionsSize);
                    String compOption = optionList.get(compIdx);
                    if (compOption.equals(userInput)) {
                        System.out.printf("There is a draw (%s)\n", compOption);
                        userRating += 50;
                    } else {
                        if (isUserWin(optionList.indexOf(userInput), compIdx, optionsSize)) {
                            System.out.printf("Well done. The computer chose %s and failed\n", compOption);
                            userRating += 100;
                        } else {
                            System.out.printf("Sorry, but the computer chose %s\n", compOption);
                        }
                    }
                } else {
                    System.out.println("Invalid userInput");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getClass().getName());
        }
    }
}
