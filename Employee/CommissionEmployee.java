/**
 * This class  represents the Commission worker.
 * It inherits from the "employee" department and the difference between her
 * and the other employees is the salary.
 * The salary of this employee is calculated according
 * to it gross sales , and commission from the sales
 * @author Nir Avigad
 * Date 07.11.21
 * Version 1.0
 */

package com.company;

import java.text.ParseException;

// Fig. 9.10: CommissionEmployee.java
// CommissionEmployee class uses methods to manipulate its 
// private instance variables.
public class CommissionEmployee extends Employee{
   private final String firstName;                        
   private final String lastName;                         
   private final String socialSecurityNumber;             
   private double grossSales; // gross weekly sales       
   private double commissionRate; // commission percentage

   // five-argument constructor
   public CommissionEmployee(String firstName, String lastName,String socialSecurityNumber
           ,String birthday, double grossSales,double commissionRate) throws ParseException {
      // implicit call to Object constructor occurs here
      super(firstName, lastName, socialSecurityNumber, birthday);

      // if grossSales is invalid throw exception
      if (grossSales < 0.0) {
         throw new IllegalArgumentException("Gross sales must be >= 0.0");
      }      

      // if commissionRate is invalid throw exception
      if (commissionRate <= 0.0 || commissionRate >= 1.0) {
         throw new IllegalArgumentException(
            "Commission rate must be > 0.0 and < 1.0");
      }      

      this.firstName = firstName;                                    
      this.lastName = lastName;                                    
      this.socialSecurityNumber = socialSecurityNumber;         
      this.grossSales = grossSales;
      this.commissionRate = commissionRate;
   } 

   // return first name
   public String getFirstName() {return firstName;}

   // return last name
   public String getLastName() {return lastName;}

   // return social security number 
   public String getSocialSecurityNumber() {return socialSecurityNumber;}

   // set gross sales amount
   public void setGrossSales(double grossSales) {
      if (grossSales < 0.0) {
         throw new IllegalArgumentException("Gross sales must be >= 0.0");
      }      

      this.grossSales = grossSales;
   } 

   // return gross sales amount
   public double getGrossSales() {return grossSales;}

   // set commission rate
   public void setCommissionRate(double commissionRate) {
      if (commissionRate <= 0.0 || commissionRate >= 1.0) {
         throw new IllegalArgumentException(
            "Commission rate must be > 0.0 and < 1.0");
      } 

      this.commissionRate = commissionRate;
   } 

   // return commission rate
   public double getCommissionRate() {return commissionRate;}

   // calculate earnings
   public double earnings() {
      return getCommissionRate() * getGrossSales();
   } 

   // return String representation of CommissionEmployee object
   @Override 
   public String toString() {
      return "commission employee :"+super.toString()+ "\ngross sales: "+getGrossSales()+
         "\ncommission rate: "+ getCommissionRate();
   } 
} 
