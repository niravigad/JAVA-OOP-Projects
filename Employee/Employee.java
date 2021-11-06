/**
 * This class is an abstract class that represents the employee, each employee must implement
 * all the methods of this class.
 * This department has the full name, date of birth and security guard number of the employee,
 * And returns great data for each employee in the various methods.
 * @author Nir Avigad
 * Date 07.11.21
 * Version 1.0
 */

package com.company;// Fig. 10.4: Employee.java
import java.text.ParseException;

public abstract class Employee {
   private final String firstName;
   private final String lastName;
   private final String socialSecurityNumber;
   private final BirthDate birthday;
   // constructor
   public Employee(String firstName, String lastName, String socialSecurityNumber, String birthday) throws ParseException {
      this.firstName = firstName;
      this.lastName = lastName;
      this.socialSecurityNumber = socialSecurityNumber;
      BirthDate birthDay = new BirthDate(birthday);
      this.birthday = birthDay;
   }

   // return first name
   public String getFirstName() {return firstName;}

   // return last name
   public String getLastName() {return lastName;}

   // return social security number
   public String getSocialSecurityNumber() {return socialSecurityNumber;}

   // return Birthday
   public String getBirthday() {return birthday.toString();}

   // return birthday month
   public Integer getMonth() {return birthday.getMonth();}

   // return String representation of Employee object
   @Override
   public String toString() {
      return String.format("%s %s%nsocial security number: %s\nbirthdate : %s",
         getFirstName(), getLastName(), getSocialSecurityNumber(),getBirthday(), birthday);
   }

   // abstract method must be overridden by concrete subclasses
   public abstract double earnings(); // no implementation here
} 
