package com.coderscampus.guessingGame;

import java.util.Random;
import java.util.Scanner;

// This is a number guessing game where a player has 5 attempts
// to correctly guess the randomly chosen number by the computer.
// between 1 and 100, inclusive.  If a number is chosen outside this range,
// the numberOfGuesses will not count against him and he will be prompted 
// to guess another number. 
//
// Once the game is complete, the player will have the option to 
// play again.  If not, the game ends, otherwise, the game begins anew.

public class GuessingGame
{
	/* the main method which executes the program */
	public static void main(String[] args)
	{
		/* assign theRandomNumber from the method */	
		int theRandomNumber = randomNumber();

		/* initialize numberOfGuesses to zero */
		int numberOfGuesses = 0;
		
		/* loop to check if we have met our 5 guess condition */
		while (numberOfGuesses < 5)
		{		
			/* prompt the user for input */			
			int numberGuessed = promptUser();

			/* check to see if number is within game parameters */
			if (numberGuessed <= 0 || numberGuessed > 100)
			{
				System.out.println("Your guess is not between 1 and 100, please try again");
			}
			else if (numberGuessed < theRandomNumber)
			{
				System.out.println("Please pick a higher number");
				numberOfGuesses++;
			} 	
			else if (numberGuessed > theRandomNumber)
			{
				System.out.println("Please pick a lower number");
				numberOfGuesses++;
			} 	
			else 
			{
				System.out.print("You win!\nThe number to guess was: " +  
				theRandomNumber + "\n");
				System.out.println("Thank you for playing the Guessing Game!");
				break;
			}
			if (numberOfGuesses == 5)
			{
				System.out.print("You lose!\nThe number to guess was: " + 
					theRandomNumber + "\n");
				System.out.println("Thank you for playing the Guessing Game!");
			}	
		}		
	}

	// method to prompt user if they wish to play again
	public static int request()
	{	
		// prompt user to play again
		System.out.println("Would you like to play again? ");
		System.out.print("Enter '1' for Yes and '0' for No ");
		Scanner input = new Scanner(System.in);
		int reply = input.nextInt();	
		
		// answer that the player would like to play again
		if (reply == 1)
		{			
			// if 'YES', reset numberOfGuesses to zero
			// and invoke request method to start new game		
//			int numberOfGuesses = 0;
//			System.out.print("Pick a number between 1 and 100 ");
//			Scanner scanner = new Scanner(System.in);
//			numberGuessed = scanner.nextInt();	
//			return numberGuessed;
			int numberOfGuesses = 0;
			int numberGuessed = promptUser();
			return numberGuessed;		
		}
		else
		{
			System.out.println("Thank you for playing the Guessing Game!");
			return 0;
		}		
	}
	
	/* method to prompt user for input */
	public static int promptUser()
	{
		System.out.print("Pick a number between 1 and 100 ");
		Scanner input = new Scanner(System.in);
		int numberGuessed = input.nextInt();
		
		return numberGuessed;		
	}
	
	/* method to generate a random number 
	 * between 1 and 100, inclusive */
	public static int randomNumber()
	{
		Random random = new Random();
		int theRandomNumber = 1 + random.nextInt(100);
		return theRandomNumber;
	}
}
