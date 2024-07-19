/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Kidoo
 */
public abstract class Game {
    protected int guessLimit;

    public Game(int guessLimit) {
        this.guessLimit = guessLimit;
    }

    public abstract void play();
    public abstract String checkGuess(int guess, String input);
}
