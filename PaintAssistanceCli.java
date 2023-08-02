/*public static void playGame(PaintMixGame game)
    {
        boolean loop = true;
        while(loop)
        {       
            System.out.println("Previous attempts:");
            if(game.getPreviousAttempts() == null)
            {
                System.out.println("No previous attempts");
            }
            else
            {
                System.out.println(game.getPreviousAttempts());
            }
            System.out.println("");   
            boolean valid = true;
            do
            {
                System.out.print("Enter paint mix:");
                String input = kbd.nextLine().toUpperCase();
                System.out.println("");   
                if(input.length() != 5)
                {
                    valid = false;
                }
                else
                {
                    for(int i = 0 ; i < 5 ; i++)
                    {
                        char character = input.charAt(i);
                        if(!(character == 'A'||character == 'B'||character == 'C'||character == 'D'||character == 'E'||character == 'F'))
                        {
                            valid = false;
                            break;
                        }
                    } 
                }
                if(valid)
                {
                    if(game.attemptPaintMix(new PaintMix(input.toCharArray())))
                    {
                        System.out.println("Congratulations!");
                        loop = false;
                    }
                }
                else
                {
                    System.out.println("");   
                    System.out.println("Invalid paint mix!");
                    kbd.nextLine();
                    System.out.println("");   
                }
            } while (!valid);
        }
    }

*/
import java.util.*;

public class PaintAssistanceCli
{

    public static Scanner kbd = new Scanner(System.in);
    
    public static void main(String[] args)
    {
        PaintMixGame main = new PaintMixGame();
        playGame(main);
    }

    public static void playGame(PaintMixGame game)
    {
        boolean firstLoop = true;
        while(firstLoop)
        {   
            System.out.println(game.getSolution());    
            System.out.println("Previous attempts:");
            if(game.getPreviousAttempts() == null)
            {
                System.out.println("No previous attempts");
            }
            else
            {
                System.out.println(game.getPreviousAttempts());
            }
            boolean secondLoop = true;
            char[] charArray = new char[0];
            while(secondLoop)
            {
                System.out.println("");
                System.out.print("Enter paint mix:");
                String stringInput = kbd.nextLine().toUpperCase();
                charArray = stringToCharArray(stringInput);
                if(isValid(charArray))
                {
                    secondLoop = false;
                }
                else
                {
                    System.out.println("");
                    System.out.println("Invalid paint mix!");
                }
            }
            PaintMix attempt = new PaintMix(charArray);
            if(game.attemptPaintMix(attempt))
            {
                System.out.println("Congratulations");
                firstLoop = false;
            }
        }
    }

    public static char[] stringToCharArray(String userInput)
    {
        char[] charArray = new char[userInput.length()];
        for(int i = 0 ; i < userInput.length() ; i++)
        {
            charArray[i] = userInput.charAt(i);
        }
        return charArray;
    }

    public static boolean isValid(char[] letters)
    {
        if(letters.length != 5)
        {
            return false;
        }
        for(char i : letters)
        {
            if(!(i == 'A' || i == 'B' || i == 'C' || i == 'D' || i == 'E' || i == 'F'))
            {
                return false;
            }

        }
         return true;
    }
}
