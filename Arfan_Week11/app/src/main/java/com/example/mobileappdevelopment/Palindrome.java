package com.example.mobileappdevelopment;

public class Palindrome extends Thread {

    private Thread t;
    private String word;
    public boolean is_palindrome;

    Palindrome( String word) {
        this.word = word;
    }

    public void run() {

        System.out.println("this is for " + word);
        int i = 0, j = word.length() - 1;
        while (i < j) {
            if (word.charAt(i) != word.charAt(j)) {
                System.out.println(word + " isnt palindrome");
                System.out.println(word + " isnt palindrome ");
                this.is_palindrome = false;
                System.out.println(word + " isnt palindrome " + is_palindrome);
                return;
            }
            i++;
            j--;
        }
        System.out.println(word + " is palindrome");
        this.is_palindrome = true;
        return;
    }

}
