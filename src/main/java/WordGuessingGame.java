/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Kidoo
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WordGuessingGame extends Game {
    private String secretWord;
    private final List<Character> guessedLetters;
    private final Scanner scanner;

    public WordGuessingGame(int guessLimit) {
        super(guessLimit);
        this.guessedLetters = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        chooseRandomFruitWord();
    }

    private void chooseRandomFruitWord() {
        List<String> fruitWords = new ArrayList<>();
        fruitWords.add("apel");
        fruitWords.add("mangga");
        fruitWords.add("jeruk");
        fruitWords.add("pisang");
        fruitWords.add("anggur");
        fruitWords.add("nanas");
        fruitWords.add("melon");
        fruitWords.add("semangka");
        fruitWords.add("pepaya");
        fruitWords.add("durian");
        Random random = new Random();
        this.secretWord = fruitWords.get(random.nextInt(fruitWords.size()));
    }

    @Override
    public void play() {
        System.out.print("Mulai tebak huruf\n");
        int guessesLeft = guessLimit;
        boolean wordGuessed = false;
        while (guessesLeft > 0 && !wordGuessed) {
            System.out.println("Sisa tebakan: " + guessesLeft);
            displayWordProgress();
            System.out.print("Tebakan Anda (nama buah): ");
            String guess = readLine();
            String result = checkGuess(0, guess);
            System.out.println(result);
            if (result.equals("Benar!")) {
                System.out.println("Kata rahasianya adalah " + secretWord);
                wordGuessed = true;
            } else {
                guessesLeft--;
            }
            if (guessesLeft == 0 && !wordGuessed) {
                System.out.println("Maaf, Anda kehabisan tebakan. Kata rahasianya adalah: " + secretWord);
            }
        }
    }

    private void displayWordProgress() {
        StringBuilder progress = new StringBuilder();
        for (int i = 0; i < secretWord.length(); i++) {
            char c = secretWord.charAt(i);
            if (guessedLetters.contains(c)) {
                progress.append(c);
            } else {
                progress.append("_");
            }
        }
        System.out.println("Kata rahasia: " + progress.toString());
        System.out.println("Huruf awal: " + secretWord.charAt(0));
    }

    private String readLine() {
        return scanner.nextLine();
    }

    /**
     *
     * @param guess
     * @param input
     * @return
     */
    @Override
    public String checkGuess(int guess, String input) {
        if (input.equalsIgnoreCase(secretWord)) {
            return "Benar!";
        } else {
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (!guessedLetters.contains(c)) {
                    guessedLetters.add(c);
                }
            }
            return "Salah";
        }
    }
}
