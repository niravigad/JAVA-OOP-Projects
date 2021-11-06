package com.company;

import java.util.Random;

public class Words {
    private String[] arr={"computer", "desk", "mouse", "key", "keyboard","jungle"};


    public  String getWord ()
    {
        Random r = new Random();
        int randomWord=r.nextInt(arr.length); //word index
        return  arr[randomWord];
    }


}
