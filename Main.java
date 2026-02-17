import java.util.*;

class Hangman {
    String word;
    char[] guessed;
    int attempts = 6;
    Set<Character> used = new HashSet<>();

    Hangman(String word) {
        this.word = word;
        guessed = new char[word.length()];
        Arrays.fill(guessed, '_');
    }

    void play() {
        Scanner sc = new Scanner(System.in);

        while (attempts > 0 && new String(guessed).contains("_")) {
            System.out.println("Word: " + String.valueOf(guessed));
            System.out.println("Attempts left: " + attempts);
            System.out.print("Guess a letter: ");
            char ch = sc.next().toLowerCase().charAt(0);

            if (used.contains(ch)) {
                System.out.println("Already guessed");
                continue;
            }

            used.add(ch);
            boolean found = false;

            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == ch) {
                    guessed[i] = ch;
                    found = true;
                }
            }

            if (!found) attempts--;
        }

        if (attempts > 0)
            System.out.println("You won! Word: " + word);
        else
            System.out.println("You lost! Word was: " + word);
    }
}

public class Main {
    public static void main(String[] args) {
        String[] words = {"java", "computer", "programming", "hangman", "developer"};
        Random r = new Random();
        String word = words[r.nextInt(words.length)];

        Hangman game = new Hangman(word);
        game.play();
    }
}
