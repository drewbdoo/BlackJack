package com.DrewBlackJack;


import java.util.Scanner;

public class BlackJack {
    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to BlackJack");
        System.out.println("Please provide the name for the player");
        String name = scan.nextLine();


        Game blackjack = new Game(name);








    }
}
