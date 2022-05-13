package com.DrewBlackJack;

import java.util.ArrayList;

public class Deck {
    //Creates a new ArrayList of cards called deck
    private ArrayList<Card> deck;

    public Deck(){
        deck = new ArrayList<Card>();
    }
    //Creates a new deck of all 52 cards
    public Deck(boolean makeDeck){
        deck = new ArrayList<Card>();
        if(makeDeck){
            //Go through all the suits first
            for(Suit suit: Suit.values()){
                //Then goes through all the ranks
                for(Rank rank: Rank.values()){
                    //adds a new card with each iteration of suit and rank
                    deck.add(new Card(suit, rank));
                }
            }
        }
    }

    public void addCard(Card card){
        deck.add(card);
    }

    public String toString(){
        //A string to hold everything we're going to return
        String output = "";

        //for each Card "card" in the deck
        for(Card card: deck){
            //add the card and the escape character for a new line
            output += card;
            output += "\n";
        }
        return output;
    }



}
