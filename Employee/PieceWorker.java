/**
 * This class  represents the Piece worker.
 * It inherits from the "employee" department and the difference between her
 * and the other employees is the salary.
 * The salary of this employee is calculated according to the number of
 * items he sold double the price of the item.
 * @author Nir Avigad
 * Date 07.11.21
 * Version 1.0
 */

package com.company;

import java.text.ParseException;

public class PieceWorker extends Employee {

    private int _items;
    private int _items_price;
    private int _piece_salary;

    public PieceWorker(String firstName, String lastName, String socialSecurityNumber, String birthday, int items , int items_price) throws ParseException {
        super(firstName, lastName, socialSecurityNumber, birthday);
        this._items = items;
        this._items_price = items_price;
        setPieceSalary( items,items_price);
    }

    // set salary
    public void setPieceSalary(int items,int price) {
        this._piece_salary = items*price;
    }
    // return salary
    public double getpieceSalary() {return _piece_salary;}

    @Override
    public double earnings () {
        return getpieceSalary();
    }

    // return String representation of SalariedEmployee object
    @Override
    public String toString () {
        return String.format("Piece employee: %s%n%s: $%,.2f",
                super.toString(), "Piece salary", getpieceSalary());
    }
    }
