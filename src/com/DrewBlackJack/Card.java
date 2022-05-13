package com.DrewBlackJack;

public class Card {

    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank){
        this.suit = suit;
        this.rank = rank;
    }

    public Card(Card card) {
        this.suit = card.getSuit();
        this.rank = card.getRank();
    }

    //Gets the numerical value of the card rank i.e. 4, 8
    public int getValue(){
        return rank.rankValue;
    }

    //Gets the Suit i.e. DIAMONDS, HEARTS
    public Suit getSuit() {
        return suit;
    }

    //Gets the rank i.e. ACE, KIND
    public Rank getRank() {
        return rank;
    }
    //Returns a string declaring the card i.e. Ace of S
    public String toString(){
        return (rank+ " of "+ suit + " ("+this.getValue()+")" );
    }


}
