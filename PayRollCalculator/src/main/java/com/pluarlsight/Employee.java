package com.pluarlsight;
public class Employee {
// Employee.java



        private int employeeId;
        private String name;
        private double hoursWorked;
        private double payRate;


        public Employee(int employeeId, String name, double hoursWorked, double payRate) {
            this.employeeId = employeeId;
            this.name = name;
            this.hoursWorked = hoursWorked;
            this.payRate = payRate;
        }

        // --- Getters ---
        public int getEmployeeId() {
            return employeeId;
        }

        public String getName() {
            return name;
        }

        public double getHoursWorked() {
            return hoursWorked;
        }

        public double getPayRate() {
            return payRate;
        }

        // --- Setters ---
        // Usually employeeId is immutable, but adding setter for completeness if needed
        public void setEmployeeId(int employeeId) {
            this.employeeId = employeeId;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setHoursWorked(double hoursWorked) {
            // Basic validation could be added here (e.g., hours >= 0)
            this.hoursWorked = hoursWorked;
        }

        public void setPayRate(double payRate) {
            // Basic validation could be added here (e.g., rate >= 0)
            this.payRate = payRate;
        }

        // --- Calculation Method ---
        /**
         * Calculates the gross pay for the employee.
         * For this simple example, it's hours worked times pay rate.
         * (No overtime calculation included yet)
         * @return The calculated gross pay.
         */
        public double getGrossPay() {
            return this.hoursWorked * this.payRate;
        }

        // Optional: toString() method for easy debugging
        @Override
        public String toString() {
            return "Employee{" +
                    "employeeId=" + employeeId +
                    ", name='" + name + '\'' +
                    ", hoursWorked=" + hoursWorked +
                    ", payRate=" + payRate +
                    '}';
        }
    }

