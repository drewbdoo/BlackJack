package com.DrewBlackJack;

import java.util.ArrayList;

public class Hand {
    //Instantiate a private arrayList of cards called hand
    private ArrayList<Card> hand;

    public Hand(){
        //Creates an empty hand
        hand = new ArrayList<Card>();
    }
    public void takeCardFromDeck(Deck deck){
        hand.add(deck.takeCard());
    }
//Method to calculate the value of the current hand including a catch case for Ace being equal to 1 or 11
    public int calculatedValue(){
        //keeping track of aces and the current total value
        int value = 0;
        int aceCount = 0;
        //For each card in this hand
        for(Card card: hand){
            //Add the card value to the hand
            value+=card.getValue();
            //Counting how many aces have been added
            if(card.getValue()==11){
                aceCount++;
            }
        }
        //this deals with multiple aces.
        if(value>21 && aceCount>0){
            while(aceCount>0 && value>21){
                aceCount--;
                value -=10;
            }
        }
        return value;
    }
    public Card getCard(int idx){
        return hand.get(idx);
    }
    public String toString(){
        String output = "";
        for(Card card: hand){
            output += card + " * ";
        }
        return "* " + output;
    }

}
