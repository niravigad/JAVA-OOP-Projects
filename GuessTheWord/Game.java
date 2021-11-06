/**
 * This class represents the game itself , implements a word from a Words object , and a chosen word object
 * which picks a random word from a list of words .
 * @author Nir Avigad
 * Date 27.10.21
 * Version 1.0
 */

package com.company;

import org.jetbrains.annotations.NotNull;
import java.util.Scanner;
import static java.lang.Character.isLetter;


public class Game {
    private int count=0,_len,_num_of_guesses=0;
    private char[] _guess;
    private char[] _lettersleft = new char[26];
    private String _word;
    private StringBuilder guesses = new StringBuilder();
    private ChosenWord chosen = new ChosenWord();
    private boolean correct = false;


    /**
     * a method which starts the game , initialize the parameters and
     * reads the input from the user (letters etc.) and if the user wants to keep playing
     * gets volume
     */
    public void startPlay()
    {
        setParams();
        while(!correct)
        {
            Scanner sc = new Scanner(System.in); //System.in is a standard input stream
            System.out.println(_guess);
            System.out.print("Enter a char: ");
            char input = sc.next().charAt(0);              //reads string
            checkWord(input);
            System.out.println(_lettersleft);

            if (count == _len)
            {
                correct = true;
                System.out.println("Correct ! Number of guesses = " + _num_of_guesses +
                                    "\nWould you like to continue playing ? y/n ");
                char decision = sc.next().charAt(0);
                if (decision == 'y') {
                    correct = false;
                    Game game = new Game();
                    game.startPlay();
                }
            }
        }
    }
    /**
     * a method which initialize the chosen word and its length
     * initialize the _guess array to the number of '_'
     * initialize the _lettersleft array to all the "abc..."
     */
    private void setParams()
    {
        int i;
        char t;
        _word = chosen.chosenWord();
        _len = _word.length();
        char[] temp = new char[_len];
        for(i=0;i<_len;i++){
            temp[i] = '_';
        }
        _guess = temp;
        for (i=0,t = 'a'; t <= 'z'; ++t,++i)
        {
            _lettersleft[i] = t;
        }
    }

    /**
     * a method which the char input from the user
     * if the input isn't letter , return
     * if the input letter has used already , return
     * removes the selected letter from the _lettersleft array
     * @param ch - the char from the user
     */

    public void checkWord (char ch)
    {
        if (!isLetter(ch))
        {
            System.out.println("You can enter alphabet only !");
            return;
        }
        if (!(hasInserted(ch)))
        {
            System.out.println("This letter has already inserted !");
            return;
        }

        for (int i = 0; i < _len; i++)
        {
            if (_word.charAt(i) == ch)
            {
                _guess[i] = ch;
                count++;
            }
        }
        ++_num_of_guesses;
        _lettersleft = removeLetter(_lettersleft,ch);
    }

    /**
     * a method which checks if the letter has already inserted.
     * removes the selected letter from the _lettersleft array
     * @param ch - the char from the user
     * @return   true if it hasn't used , else false.
     */

    public boolean hasInserted (char ch)
    {
        for (int i = 0; i < _lettersleft.length; i++)
        {
            if (_lettersleft[i] == ch)
                return true;
        }
        return false;
    }

    /**
     * a method which removes the letter from the _lettersleft array
     * @param ch - the char from the user
     * @param \char [] original - the _lettersleft array
     * @return   the new _lettersleft array without the ch
     */

    public char[] removeLetter(char @NotNull [] original, char ch)
    {
        char[] result = new char[original.length - 1];
        int last_insert = 0;
        for (int i = 0; i < original.length; i++) {
            if (_lettersleft[i] == ch)
                i++;
            result[last_insert++] = original[i];
        }
        return result;
    }
}
