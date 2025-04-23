package com.pluarlsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

// PayrollCalculator.java

import java.io.FileWriter; // Added for writing files
import java.io.PrintWriter; // Added for easier file writing
import java.util.Scanner; // Added for user input

public class PayRollCalculator {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in); // Create Scanner for user input

        // Prompt for and get the input file name
        System.out.print("Enter the name of the employee file to process: ");
        String inputFileName = userInput.nextLine();

        // Prompt for and get the output file name
        System.out.print("Enter the name of the payroll file to create: ");
        String outputFileName = userInput.nextLine();

        System.out.println("Processing payroll...");

        // Use try-with-resources for automatic closing of reader AND writer
        try (FileReader fileReader = new FileReader(inputFileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter(outputFileName); // Create FileWriter
             PrintWriter printWriter = new PrintWriter(fileWriter)) // Wrap FileWriter in PrintWriter
        {

            String line;
            // Optional: Write a header row to the CSV file (if desired)
            // printWriter.println("id|name|gross pay");

            // Read each line of the input file
            while ((line = bufferedReader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue; // Skip empty lines
                }

                String[] tokens = line.split("\\|");

                if (tokens.length == 4) {
                    try {
                        // Parse data
                        int id = Integer.parseInt(tokens[0].trim());
                        String name = tokens[1].trim();
                        double hours = Double.parseDouble(tokens[2].trim());
                        double rate = Double.parseDouble(tokens[3].trim());

                        // Create Employee object
                        Employee employee = new Employee(id, name, hours, rate);

                        // Write the formatted output to the CSV file
                        printWriter.printf("%d|%s|%.2f%n", // Use %d, %s, %.2f for int, String, double (2 decimal places)
                                employee.getEmployeeId(),
                                employee.getName(),
                                employee.getGrossPay()); // %n for newline

                    } catch (NumberFormatException e) {
                        System.err.println("Skipping invalid line (parsing error): " + line + " -> " + e.getMessage());
                        // Optionally write errors to a separate log file
                    } catch (Exception e) {
                        System.err.println("Skipping line due to unexpected error: " + line + " -> " + e.getMessage());
                    }
                } else {
                    System.err.println("Skipping malformed line (incorrect number of fields): " + line);
                }
            } // End while loop

            // If the loop finishes without errors, print success message
            System.out.println("Payroll data successfully written to: " + outputFileName);

        } catch (FileNotFoundException e) {
            // Handle case where the INPUT file is not found
            System.err.println("Error: Input file not found: " + inputFileName);
            // e.printStackTrace(); // Uncomment for detailed debug info
        } catch (IOException e) {
            // Handle generic IO errors for reading or WRITING
            System.err.println("Error processing files: " + e.getMessage());
            // e.printStackTrace(); // Uncomment for detailed debug info
        } finally {
            // Close the scanner when we are completely done with it
            userInput.close();
        }
    }
}

