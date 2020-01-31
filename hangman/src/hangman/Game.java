package hangman;
import java.util.Arrays;
import java.util.Scanner;

public class Game {
	private String[] words = {"apple", "pear", "cherry", "mango"};
	private String word;
	private char[] guessWord;
	
	public Game() {
		word = words[(int)(Math.random() * 4)];
		guessWord = new char[word.length()];
		Arrays.fill(guessWord, '_');
	}
	public void getArray() {
		for (char element : guessWord) {
			System.out.print(element + " ");
		}
	}
	public void getWord() {
		System.out.println(word);
	}
	public boolean isGuessed() {
		for (char element : guessWord) {
			if (element == '_') return false;
		}
		return true;
	}
	public void takeGuess(Scanner in) {
		char letter = in.nextLine().charAt(0);
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == letter) {
				guessWord[i] = letter;
			}
		}
	}
	public void Play() {
		int guessCount = 10;
		Scanner input = new Scanner(System.in);
		while (guessCount > 0) {
			getArray();
			takeGuess(input);
			if (isGuessed()) {
				System.out.println("You won!");
				break;
			} else {
				guessCount--;
			}
		}
		input.close();
		if (guessCount == 0) {
			System.out.println("\nGame over!");
			System.out.println("The word was - " + word);
		}
	}
}