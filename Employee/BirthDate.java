/**
 * This class represents the employee's birthday, Gets a date as a string and
 * converts it to a real date in the Date class
 * @author Nir Avigad
 * Date 07.11.21
 * Version 1.0
 */

package com.company;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class BirthDate
{
    private Date _date_of_birth;

    public BirthDate(String birth) throws ParseException {
        Date date=new SimpleDateFormat("dd/mm/yyyy").parse(birth);
        this._date_of_birth = date;
    }
    // return DateOfBirth
    public String toString(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        String strDate = dateFormat.format(this._date_of_birth);
        return strDate;
    }
    // Get month
    public Integer getMonth(){
        DateFormat dateFormat = new SimpleDateFormat("mm");

        String strMonth = dateFormat.format(this._date_of_birth);
        int birth_month = Integer.parseInt(strMonth);
        return birth_month;
    }

}

