package com.exercise5;

import java.util.ArrayList;
import java.util.Scanner;

public class SubSequence {
    public static ArrayList<String> subStrings = new ArrayList<>();
    public static void matchSubstring(String subStr, String letter)
    {
        if(!letter.contains(String.valueOf(subStr.charAt(0))))
            return;

        ArrayList<String> charOfLetter = new ArrayList<>();
        for(int i=0; i<letter.length(); i++)
            charOfLetter.add(String.valueOf(letter.charAt(i)));

        String temp="";
        int i=0;
        while(!charOfLetter.isEmpty())
        {
            temp += String.valueOf(subStr.charAt(i));
            if(charOfLetter.contains(String.valueOf(subStr.charAt(i))))
            {
                charOfLetter.remove(String.valueOf(subStr.charAt(i)));
            }
            if(i < subStr.length()-1)
                i++;
            else
                break;
        }
        if(charOfLetter.isEmpty())
            subStrings.add(temp);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        String letter = input.nextLine();

        for(int i=0; i<str.length(); i++)
        {
            matchSubstring(str.substring(i), letter);
        }

        Integer minLength = str.length();
        for(int i=0; i<subStrings.size(); i++)
        {
            if(minLength > subStrings.get(i).length())
                minLength = subStrings.get(i).length();
        }

        for(int i=0; i<subStrings.size(); i++)
        {
            if(minLength == subStrings.get(i).length())
               {
                   System.out.print(subStrings.get(i));
                   break;
               }
        }
    }
}


/*

qploresinazxrhqknhoilerthf
lion

MKWPLNHNNKLASOPQLRHLI
HILL

1qnkyp098fSkkmnQryS9pkYn0Qd7mksy0fRW0a7Sxzc
Sky07
 */