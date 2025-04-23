package com.plurasight;

import java.util.Scanner;
import java.util.InputMismatchException;


public class FamousQuotes {

    public static void main(String[] args) {

        // 1. Create an array of strings and add 10 quotes.
        String[] quotes = {
                "The only way to do great work is to love what you do. - Steve Jobs",
                "Strive not to be a success, but rather to be of value. - Albert Einstein",
                "The mind is everything. What you think you become. - Buddha",
                "An unexamined life is not worth living. - Socrates",
                "Your time is limited, don't waste it living someone else's life. - Steve Jobs",
                "The best way to predict the future is to create it. - Peter Drucker",
                "Everything you can imagine is real. - Pablo Picasso",
                "Life is what happens when you're busy making other plans. - John Lennon",
                "Whether you think you can or you think you can't, you're right. - Henry Ford",
                "It does not matter how slowly you go as long as you do not stop. - Confucius"
        };



        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        boolean validInput = false;


        while (!validInput) {
            System.out.print("Enter a number between 1 and 10 to select a quote: ");

            try {
                choice = scanner.nextInt(); // Try to read an integer


                if (choice >= 1 && choice <= 10) {
                    validInput = true; // Input is valid, exit the loop
                } else {
                    System.out.println("Invalid input. Please enter a number *between* 1 and 10.");
                }
            } catch (InputMismatchException e) {
                // Handle the case where the input wasn't an integer
                System.out.println("Invalid input. Please enter a whole number.");
                scanner.next(); // Consume the invalid input to prevent an infinite loop
            } catch (Exception e) {
                // Handle other potential unexpected errors
                System.err.println("An unexpected error occurred: " + e.getMessage());
                scanner.next(); // Consume potentially problematic input
            }
        }

        // 3. Display the selected quote.
        //    Remember that array indices start at 0, so subtract 1.
        int selectedIndex = choice - 1;
        String selectedQuote = quotes[selectedIndex];

        System.out.println("--------------------");
        System.out.println("Quote #" + choice + ":");
        System.out.println(selectedQuote);
        System.out.println("--------------------");

        scanner.close(); // Close the scanner to release system resources
    }
}




