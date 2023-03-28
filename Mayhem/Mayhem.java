package filetest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Random;
import java.util.Scanner;
import java.util.*;



public class ReadSelectWord {



	public static void main (String[] args) throws IOException {
		String selectedWord = ReadFile();
		System.out.println(selectedWord); // Prints the selected word to the console for testing purposes.

		
	}
	
	// The following code reads the word list file and selects a random word from the list of words.
	// The code takes has no specific inputs but creates and runs the Mayhem game
	public static String ReadFile() throws IOException {
		File wordlist = new File("C:\\Users\\David Yang\\Downloads\\google-10000-english-no-swears.txt");
		FileReader fileReader = new FileReader(wordlist);
		LineNumberReader reader = new LineNumberReader(fileReader);

		int count = 1;

		FileInputStream fileInput = new FileInputStream(wordlist);
		Scanner scannerObject = new Scanner(fileInput);
		while (scannerObject.hasNextLine()) {
			scannerObject.nextLine();
		    count += 1;
		}
		
		// This section selects a random word from the list of words.
        Random r = new Random();
        int random = r.nextInt(count);
		String word = "";

		int lines = 0;
		while (word != null) {
			lines += 1;
            word = reader.readLine();
            if (lines == random) {
                break;
            }
        }
		

		reader.close();
        fileReader.close();
        scannerObject.close();

	
		char[] arr = word.toCharArray();
		Random rand = new Random();

		
		for (int c = 0; c < arr.length; ++ c){
    		int index = rand.nextInt(arr.length - c);
			char tmp = arr[arr.length - 1 - c];
			arr[arr.length - 1 - c] = arr[index];
			arr[index] = tmp;}
		
		// Turn Array of Characters back into a string
		String string = new String(arr);
		
		
		// scores are for rounds while scoreboards are for games
		int score1 = 0;
		int score2 = 0;
		int scoreboard1 = 0;
		int scoreboard2 = 0;
		
		// User text
		Scanner sc = new Scanner(System.in); //System.in is a standard input stream  
		System.out.print("Player 1, Enter your username: ");  
		String str = sc.nextLine();              //reads string  
		System.out.println("Hello: " + str);
		System.out.print("Player 2, Enter your username: ");  
		String str2 = sc.nextLine();
		System.out.println("Hello: " + str2);
		System.out.print("Enter any key to start:");  
		String str3 = sc.nextLine();

		// Counts are used for keeps score for every failed attempt in a round
		int count1 = 0;
		int count2 = 5;
		// used to alternate players
		int counter = 0;

		
		
		
		while((counter % 2 == 0)||(count % 2 == 1)){


			// connects the counter system with player indication
			if (counter % 2 == 0){System.out.println(str + "'s turn: " + string);
			}
			if (counter % 2 == 1){System.out.println(str2 + "'s turn: " + string);
			}

			// How many possible attempts per round
			for (int i = 0; i < 5; i ++){

		
				System.out.println("Enter 'pass' if you'd like to forfeit your turn.");
				System.out.println("Enter 'see' if you'd like to see the word.");
				String str4 = sc.nextLine(); 
		
				String userInput = String.valueOf(str4);

				// Checks for a match and adjusts score accordingly
				if (userInput.equals(word) && counter % 2 == 0){score1 = count2 - count1; 
					scoreboard1 = score1 + scoreboard1;
					System.out.println("Good Job! You got " + score1 + " points!");
					System.out.println("You have " + scoreboard1 + " total points!");
					i =+ 5;
				}

				// Same thing budget for player 2
				if (userInput.equals(word) && counter % 2 == 1){score2 = count2 - count1; 
					scoreboard2 = score2 + scoreboard2;
					System.out.println("Good Job! You got " + score2 + " points!");
					System.out.println("You have " + scoreboard2 + " total points!");
					i =+ 5;
				}

				// Pass option
				if (userInput.equals("pass") && counter % 2 == 0){score1 = score1 + 0;
					System.out.println("Maybe Next Time! 0 points. You have " + scoreboard1 + " total points!");
					i =+ 5;
				}

				if (userInput.equals("pass") && counter % 2 == 1){score2 = score2 + 0;
					System.out.println("Maybe Next Time! 0 points. You have " + scoreboard2 + " total points!");
					i =+ 5;
				}
				// Reveal the word option
				if (userInput.equals("see")&& counter%2 == 0){score1 = score1 + 0;
					System.out.println(word + " 0 points");
					System.out.println("You have " + scoreboard1 + " total points!");
					i =+ 5;
				}

				if (userInput.equals("see")&& counter%2 == 1){score2 = score2 + 0;
					System.out.println(word + " 0 points");
					System.out.println("You have " + scoreboard2 + " total points!");
					i =+ 5;
				}

				// All other possible inputs
				if (!(userInput.equals(word)||userInput.equals("pass")||
					userInput.equals("see")) && counter % 2 == 0){
					System.out.println("Nice try!");
					System.out.println("You have " + scoreboard1 + " total points!");
					count1 ++; System.out.println("Attempt " + count1);
				}

				if (!(userInput.equals(word)||userInput.equals("pass")||
					userInput.equals("see")) && counter % 2 == 1){
					System.out.println("Nice try!");
					System.out.println("You have " + scoreboard2 + " total points!");
					count1 ++;
					System.out.println("Attempt " + count1);
				}



				// Check the scoreboards to determine the winner or a tie
				if (scoreboard1 >= 40){System.out.println(str + " is the winner!");
				return "Game over!";
				}
				if (scoreboard2 >= 40){System.out.println(str2 + " is the winner!");
				return "Game over!";
				}
				if (scoreboard1 >= 40 && scoreboard2 >= 40)
				{System.out.println(str +" and " + str2 + " tied!");return "Game over!";}}

				counter ++;continue;
			}
		// Ends the game
 		return " Gameover"; 

	}

    
	


}

