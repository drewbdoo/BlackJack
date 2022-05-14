package com.DrewBlackJack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

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
    //Shuffles the deck
    public void shuffle(){
        //Using built in Collections suffle method
        Collections.shuffle(deck, new Random());

//        //Next lines are for education on how the shuffling works
//        ArrayList<Card> shuffled = new ArrayList<Card>();
//        while (deck.size()>0){
//            /*Selects a card - the cartToPull is generating the index of the card to select
//            by multiplying a random 0-1 number by the deck size-1*/
//            int cartToPull = (int) (Math.random()*(deck.size()-1));
//            //Adds that card to the new suffled arraylist
//            shuffled.add(deck.get(cartToPull));
//            //Removes that card from the original deck
//            deck.remove(cartToPull);
//        }
//        //Sets the old deck to the newly shuffled one
//        deck = shuffled;

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

    //Takes a top card from the deck and removes it at the same time
    public Card takeCard() {
        //Takes the top card - makes a new Card by passing in an existing card from the deck array
        Card cardToTake = new Card(deck.get(0));
        //Removes the card
        deck.remove(0);
        //Return that card
        return cardToTake;
    }

    public boolean hasCards(){
        if(deck.size()>0){
            return true;
        }else{
            return false;
        }
    }
    //Empties the deck
    public void emptyDeck(){
        deck.clear();
    }
    public void addCards(ArrayList<Card> cards){
        deck.addAll(cards);
    }
    public ArrayList<Card> getCards() {
        return deck;
    }

    /*Take all the cards from the discard pile and place them in this deck, shuffled
    clear the old deck
    discard the deck we are getting the cards from
     */
    public void reloadDeckFromDiscard(Deck discard){
        this.addCards(discard.getCards());
        this.shuffle();
        discard.emptyDeck();
        System.out.println("Ran out of cards, dealer takes the discarded cards and shuffles them into a fresh deck.");
    }


    public int cardsLeft() {
        return deck.size();
    }
}
