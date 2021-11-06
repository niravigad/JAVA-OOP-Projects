/**
 * This class represents The main organization of the exercise, creates different objects
 * from each type of employee, displays them in an array and displays data of each employee
 * @author Nir Avigad
 * Date 07.11.21
 * Version 1.0
 */

package com.company;
import java.util.Calendar;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {
        // create subclass objects
        SalariedEmployee salariedEmployee =
                new SalariedEmployee("John", "Smith", "111-11-1111","27/11/1994", 800.00);
        HourlyEmployee hourlyEmployee =
                new HourlyEmployee("Karen", "Price", "222-22-2222","26/12/1994",16.75, 40);
        CommissionEmployee commissionEmployee =
                new CommissionEmployee("Sue", "Jones", "333-33-3333","25/10/1994",10000, .06);
        BasePlusCommissionEmployee basePlusCommissionEmployee =
                new BasePlusCommissionEmployee("Bob", "Lewis", "444-44-4444","24/9/1994",5000, .04, 300);
        PieceWorker pieceWorker =
                new PieceWorker("Bob", "Lewis", "444-44-4444","24/9/1994",100, 10);

        System.out.println("Employees processed individually:");

        System.out.printf("%n%s%n%s: $%,.2f%n%n",
                salariedEmployee, "earned", salariedEmployee.earnings());
        System.out.printf("%s%n%s: $%,.2f%n%n",
                hourlyEmployee, "earned", hourlyEmployee.earnings());
        System.out.printf("%s%n%s: $%,.2f%n%n",
                commissionEmployee, "earned", commissionEmployee.earnings());
        System.out.printf("%s%n%s: $%,.2f%n%n",
                basePlusCommissionEmployee,
                "earned", basePlusCommissionEmployee.earnings());

        // create four-element Employee array
        Employee[] employees = new Employee[5];

        // initialize array with Employees
        employees[0] = salariedEmployee;
        employees[1] = hourlyEmployee;
        employees[2] = commissionEmployee;
        employees[3] = basePlusCommissionEmployee;
        employees[4] = pieceWorker;

        Calendar currentDate = Calendar.getInstance();
        int month = currentDate.get(Calendar.MONTH)+1;

        System.out.printf("Employees processed polymorphically:%n%n");

        // generically process each element in array employees
        for (Employee currentEmployee : employees) {
            System.out.println(currentEmployee); // invokes toString

            // determine whether element is a BasePlusCommissionEmployee
            if (currentEmployee instanceof BasePlusCommissionEmployee) {
                // downcast Employee reference to
                // BasePlusCommissionEmployee reference
                BasePlusCommissionEmployee employee =
                        (BasePlusCommissionEmployee) currentEmployee;

                employee.setBaseSalary(1.10 * employee.getBaseSalary());

                System.out.printf(
                        "new base salary with 10%% increase is: $%,.2f%n",
                        employee.getBaseSalary());
            }
            // determine whether the employee has birthday this month
            if ( currentDate.get(Calendar.MONTH)+1 == currentEmployee.getMonth()) {
                currentEmployee.earnings();
                System.out.println("Happy birthday! you got a bonus of 200$!");
                System.out.printf(
                        "earned $%,.2f%n%n", currentEmployee.earnings()+200);
            }
            else {
                System.out.printf(
                        "earned $%,.2f%n%n", currentEmployee.earnings());
            }
        }

        // get type name of each object in employees array
        for (int j = 0; j < employees.length; j++) {
            System.out.printf("Employee %d is a %s%n", j,
                    employees[j].getClass().getName());
        }
    }
}