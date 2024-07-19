/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Kidoo
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private static final int MAX_GUESS_LIMIT = 7;
    private final Scanner scanner;

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean isRunning = true;
        Game game = null;
        while (isRunning) {
            displayMainMenu();
            int choice = readInt("Pilihan Anda: ");
            switch (choice) {
                case 1 -> {
                    game = new NumberGuessingGame(MAX_GUESS_LIMIT);
                    game.play();
                }
                case 2 -> {
                    game = new WordGuessingGame(MAX_GUESS_LIMIT);
                    game.play();
                }
                case 3 -> {
                    System.out.println("Terima kasih telah bermain!");
                    isRunning = false;
                }
                default -> System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    private void displayMainMenu() {
        System.out.println("Selamat Datang di Permainan Tebak-Tebakan!");
        System.out.println("Silakan pilih permainan:");
        System.out.println("1. Tebak Angka");
        System.out.println("2. Tebak Kata");
        System.out.println("3. Keluar");
    }

    private int readInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Silakan masukkan angka.");
                scanner.nextLine(); // Mengkonsumsi input yang salah
            }
        }
    }
}

