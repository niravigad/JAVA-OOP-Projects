/**
 * This class  represents the Base + Commission worker.
 * It inherits from the "CommissionEmployee" department and the difference between her
 * and the other employees is the salary.
 * The salary of this employee is calculated according
 * to it gross sales , and commission from the sales , and a base salary
 * @author Nir Avigad
 * Date 07.11.21
 * Version 1.0
 */

package com.company;

import java.text.ParseException;

// Fig. 9.11: BasePlusCommissionEmployee.java
// BasePlusCommissionEmployee class inherits from CommissionEmployee 
// and accesses the superclass�s private data via inherited 
// public methods.
public class BasePlusCommissionEmployee extends CommissionEmployee {
   private double baseSalary; // base salary per week

   // six-argument constructor
   public BasePlusCommissionEmployee(String firstName, String lastName,String socialSecurityNumber
           ,String birthday, double grossSales,double commissionRate, double baseSalary) throws ParseException {
      super(firstName, lastName, socialSecurityNumber,birthday,grossSales, commissionRate);

      // if baseSalary is invalid throw exception
      if (baseSalary < 0.0) {                  
         throw new IllegalArgumentException("Base salary must be >= 0.0");
      }       

      this.baseSalary = baseSalary;
   }
   
   // set base salary
   public void setBaseSalary(double baseSalary) {
      if (baseSalary < 0.0) {                  
         throw new IllegalArgumentException("Base salary must be >= 0.0");
      }       

      this.baseSalary = baseSalary;                
   } 

   // return base salary
   public double getBaseSalary() {return baseSalary;}

   // calculate earnings
   @Override 
   public double earnings() {return getBaseSalary() + super.earnings();}

   // return String representation of BasePlusCommissionEmployee
   @Override
   public String toString() {
      return String.format("%s %s%n%s: %.2f", "base-salaried",
         super.toString(), "base salary", getBaseSalary());   
   } 
} 
