package com.DrewBlackJack;

import com.blackjack.Game;

public class BlackJack {
    public static void main(String[] args) {
        System.out.println("Welcome to BlackJack");
        Game blackjack = new Game();
        Deck testDeck = new Deck(true);
        System.out.println(testDeck);



    }
}
