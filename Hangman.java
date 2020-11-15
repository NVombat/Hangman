//Program to implement Hangman Game:

import java.util.Scanner;
public class Main
{
	    public static void main(String[] args) throws Exception
	    {
            ArrayList<String> movieList = new ArrayList();
            
            //input file
            File file = new File ("movies.txt");
            Scanner scanner = new Scanner(file);

            //Add movie titles to array
            while(scanner.hasNextLine())
            {
                movieList.add(scanner.nextLine().toLowerCase());
            }

            //Random Line from File
            int randomLine = (int) (Math.random() * (movieList.size())) - 1 ;
            String movie = movieList.get(randomLine); //Movie name
	    int l = movie.length(); //Calculates length of movie name 
	    System.out.println("Movie name is " + l + " letters long"); //includes spaces in the letters
	    
	    char [] result = new char [l]; //Creates Char array of length l and initialises it 
	    
	    for(int i=0; i<l; i++)
	    {
	        if(movie.charAt(i)==' ') //If movie name has space then print space
	        {
	            System.out.print("  ");
	            i++; //increments if space was printed (Since space is also a char in a string)
	        }
	        result[i]= '_'; //sets all elements of result array to '_'
	        System.out.print(result[i] + " ");
	    }
	    System.out.println(); //New line 
	    
	    int cnt = 0; //Sets counter to 0
	    
	    while(cnt<10) //Counts till 9 i.e 10 guesses
	    {
	        boolean g = false;
	        
	        Scanner scanner = new Scanner(System.in); //Creates new scanner
	        char guess = scanner.next().charAt(0); //Users guess = Input for character
	        System.out.println("Your guess = "+guess);
	        
	        for(int j=0; j<l; j++)
	        {
	            if(guess==movie.charAt(j)) //checks if guess is in the movie name
	            {
	                result[j]=guess; //updates result array from '_' to the guessed char
	                g=true; //g will be true if guess is correct 
	            }
	        }
	        
	        int letter = 0; //sets a counter 
	        boolean check = false; //to check for game completion
	        for(int k=0; k<l; k++)
	        {
	            if(result[k]==movie.charAt(k)) //if letter from result array matches letter from movie name
	            {
	               letter++;
	            }
	            else if(movie.charAt(k)==' ') //increment if space is there (since space is a character)
	            {
	                letter++;
	            }
	            else
	            {
	                check = false; //if letters dont match then break out of loop
	                break;
	            }
	        }
	        
	        if(letter == l) //if letter counter == length of string it means all guessed letters match movie name
	        {
	            for(int i=0; i<l; i++)
	            {
	                System.out.print(result[i] + " "); //prints final answer
	            }
	            System.out.println(); //New line
	            
	            System.out.println("You WIN! You guessed " + movie.toUpperCase() + " correctly"); //game won
	            break; //break out of while loop
	        }
	        
	        if(!g) //if guess is incorrect then g becomes false and error message is outputted 
	        {
	            cnt++; //increments counter
	            System.out.println("Wrong Letter - You have " + (10-cnt) + " guesses left");
	        }
	        
	        for(int i=0; i<l; i++)
	        {
	            System.out.print(result[i] + " "); //prints updated result array with guesses filtered in 
	        }
	        System.out.println(); //New line
	    }
	    if(cnt==10) //If number of guesses are over
	    {
	        System.out.println("You Lose:( Movie was " + movie.toUpperCase()); //If 10 guesses have been used - Game is lost
	    }
	}
}


