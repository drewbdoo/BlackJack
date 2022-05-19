package com.DrewBlackJack;

public enum Suit {
    DIAMOND("Diamonds"),
    HEART("Hearts"),
    SPADE("Spades"),
    CLUB("Clubs");


    String suitName;
    Suit(String suitName){
        this.suitName = suitName;
    }

    public String toString(){
    return suitName;
    }
}
