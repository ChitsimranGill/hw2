

import java.util.Scanner;

/**
   A telephone that takes simulated keystrokes and voice input
   from the user and simulates spoken text.
*/
public class Telephone
{
   /**
      Construct phone object.
      @param aScanner that reads text from a character-input stream
   */
   public Telephone(Scanner aScanner)
   {
      scanner = aScanner;
   }

   /**
      Speak a message to System.out.
      @param output the text that will be "spoken"
   */
   public void speak(String output)
   {
      System.out.println(output);
   }

   /**
      Loops reading user input and passes the input to the
      Connection object's methods dial, record or hangup.
      @param c the connection that connects this phone to the
      voice mail system
   */
   public void run(Connection c)
   {
      boolean more1 = true;
      int count = 0;
      
    	  	Scanner s1 = new Scanner(System.in);
        while (more1)
        {
        		Integer test1 = s1.nextInt();
        		boolean more = true;
        		if (test1 == 1) // for leaving message
        		{
        			System.out.println("Enter mailbox number followed by #");
        			while (more)
        			{
        				String input = scanner.nextLine();
        				if (input == null) return;
        				if (input.equalsIgnoreCase("H"))
        				{
        					count = 0;
        					c.hangup();
        					more = false;
        					c.connectCheck = 0;
        					c.recordCheck = 0;
        				}
        				else if (input.equalsIgnoreCase("Q"))
        				{
        					more = false;
        					more1 = false;
        				}
        				else if (input.length() == 1 && "1234567890#".contains(input) && c.connectCheck!=1)
        				{
        					c.dial(input);
        				}
        				else if (c.recordCheck !=1 && c.connectCheck ==1)
        				{
        					c.record(input);
        				}
        			}
        		}
        		else if (test1 ==2) // for accessing mailbox
        		{
        			System.out.println("Enter mailbox number followed by #");
        			while(more)
        			{
        				String input = scanner.nextLine();
        				if(input == null) return;
        				if (input.equalsIgnoreCase("H"))
        				{
        					c.hangup();
        					more = false;
        				}
        				else if (input.equalsIgnoreCase("Q"))
        				{
        					more = false;
        					more1 = false;
        				}
        				else if (input.length() == 1 && "1234567890#".contains(input))
        				{
        					c.dial2(input);
        				}
        				else if (c.loginCheck == 1 && "123".contains(input)==false && c.mailboxCheck !=1 )
        				{
        					System.out.println("Enter 1 to listen to your messages\n"
        							+ "Enter 2 to change your passcode\n"
        							+ "Enter 3 to change your greeting");
        				}
        				else if (c.loginCheck == 1 && "123".contains(input)==false && c.mailboxCheck ==1 )
        				{
        					System.out.println("Enter 1 to listen to the current message\n"
        							+ "Enter 2 to save the current message\n"
        							+ "Enter 3 to delete the current message\n"
        							+ "Enter 4 to return to the main menu");
        				}
        		
        			}
        	
        		}
        }
   }
   
   
   private Scanner scanner;
}