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
                System.out.println("Enter paint mix:");
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
                    System.out.println("");   
                }
            } while (!valid);
        }
    }
}


