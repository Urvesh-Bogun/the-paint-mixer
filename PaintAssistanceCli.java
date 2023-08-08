import java.util.*;

public class PaintAssistanceCli {

    public static Scanner kbd = new Scanner(System.in);

    //Shows previous attempts and calls the other methods
    public static void playGame(PaintMixGame game) {
        boolean firstLoop = true;
        while (firstLoop) {
            System.out.println("Previous attempts:");
            if (game.getPreviousAttempts() == null) {
                System.out.println("No previous attempts");
            } else {
                System.out.println(game.getPreviousAttempts());
            }
    
            char[] charArray = getUserInput();
            PaintMix attempt = new PaintMix(charArray);
    
            if (game.attemptPaintMix(attempt)) {
                System.out.println("Congratulations!");
                firstLoop = false;
            }
        }
    }

    //Converts user input (String) into a character array
    public static char[] stringToCharArray(String userInput) {
        char[] charArray = new char[userInput.length()];
        for(int i = 0 ; i < userInput.length() ; i++) {
            charArray[i] = userInput.charAt(i);
        }
        return charArray;
    }

    //Asks for user input
    public static char[] getUserInput() {
        while (true) {
            System.out.print("Enter your paint mixture guess (use A to E): ");
            String stringInput = kbd.nextLine().toUpperCase();
            char[] charArray = stringToCharArray(stringInput);
            if (isValid(charArray)) {
                return charArray;
            } else {
                System.out.println("Invalid paint mix!");
            }
        }
    }

    //Checks validity of user input
    public static boolean isValid(char[] letters)
    {
        if(letters.length != 5) {
            return false;
        }
        for(char i : letters) {
            if(!(i == 'A' || i == 'B' || i == 'C' || i == 'D' || i == 'E')) {
                return false;
            }
        }
         return true;
    }

    public static void main(String[] args) {
        PaintMixGame main = new PaintMixGame();
        playGame(main);
    }
}
