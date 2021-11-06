package com.company;

public class ChosenWord {


    Words word = new Words();
    String chose;

    public String chosenWord (){
        chose = word.getWord();
        return chose;
    }

}
