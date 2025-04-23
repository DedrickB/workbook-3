package com.pluarlsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

    public class PayRollCalculator {

        public static void main(String[] args) {
            String inputFileName = "employees.csv";

            System.out.println("Reading employee data from: " + inputFileName);
            System.out.println("--- Payroll Report ---");
            System.out.printf("%-5s %-20s %-10s%n", "ID", "Name", "Gross Pay"); // Header
            System.out.println("-------------------------------------");


            try (FileReader fileReader = new FileReader(inputFileName);
                 BufferedReader bufferedReader = new BufferedReader(fileReader)) {

                String line;
                // Read each line of the file until the end is reached (readLine() returns null)
                while ((line = bufferedReader.readLine()) != null) {
                    // Skip empty lines or potential header lines if needed (optional)
                    if (line.trim().isEmpty()) {
                        continue;
                    }


                    String[] tokens = line.split("\\|");

                    // Ensure the line has the correct number of fields
                    if (tokens.length == 4) {
                        try {
                            // 4. Copy values, parse them, and create Employee object
                            int id = Integer.parseInt(tokens[0].trim());
                            String name = tokens[1].trim();
                            double hours = Double.parseDouble(tokens[2].trim());
                            double rate = Double.parseDouble(tokens[3].trim());

                            Employee employee = new Employee(id, name, hours, rate);


                            System.out.printf("%-5d %-20s $%,-9.2f%n",
                                    employee.getEmployeeId(),
                                    employee.getName(),
                                    employee.getGrossPay());

                        } catch (NumberFormatException e) {
                            System.err.println("Skipping invalid line (parsing error): " + line + " -> " + e.getMessage());
                        } catch (Exception e) {
                            // Catch other potential errors during processing a line
                            System.err.println("Skipping line due to unexpected error: " + line + " -> " + e.getMessage());
                        }
                    } else {
                        System.err.println("Skipping malformed line (incorrect number of fields): " + line);
                    }
                } // End while loop

            } catch (FileNotFoundException e) {
                System.err.println("Error: Input file not found: " + inputFileName);
                e.printStackTrace(); // Print stack trace for debugging
            } catch (IOException e) {
                System.err.println("Error reading from file: " + inputFileName);
                e.printStackTrace(); // Print stack trace for debugging
            }

            System.out.println("-------------------------------------");
            System.out.println("--- End of Report ---");
        }
    }

