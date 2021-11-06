/**
 * This class  represents the Salaried worker.
 * It inherits from the "employee" department and the difference between her
 * and the other employees is the salary.
 * The salary of this employee is calculated according
 * to a regular weekly payment
 * @author Nir Avigad
 * Date 07.11.21
 * Version 1.0
 */

package com.company;// Fig. 10.5: SalariedEmployee.java
// SalariedEmployee concrete class extends abstract class Employee.

import java.text.ParseException;

public class SalariedEmployee extends Employee {
   private double weeklySalary;

   // constructor
   public SalariedEmployee(String firstName, String lastName,String socialSecurityNumber,String birthday, double weeklySalary) throws ParseException {
      super(firstName, lastName, socialSecurityNumber, birthday);

      if (weeklySalary < 0.0) {
         throw new IllegalArgumentException(
            "Weekly salary must be >= 0.0");
      }

      this.weeklySalary = weeklySalary;
   } 

   // set salary
   public void setWeeklySalary(double weeklySalary) {
      if (weeklySalary < 0.0) {
         throw new IllegalArgumentException(
            "Weekly salary must be >= 0.0");
      }

      this.weeklySalary = weeklySalary;
   } 

   // return salary
   public double getWeeklySalary() {return weeklySalary;}

   // calculate earnings; override abstract method earnings in Employee
   @Override                                                           
   public double earnings() {return getWeeklySalary();}

   // return String representation of SalariedEmployee object  
   @Override                                                   
   public String toString() {                                  
      return String.format("salaried employee: %s%n%s: $%,.2f",
         super.toString(), "weekly salary", getWeeklySalary());
   }                                                           
} 
