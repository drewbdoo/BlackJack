package com.DrewBlackJack;

public class Dealer extends Person {

    public Dealer(){
        //Sets the name to "Dealer"
        super.setName("Dealer");
    }

    //Shows the dealer's first hand
    public void printFirstHand(){
        System.out.println("The dealer's hand looks like this: ");
        System.out.println("* "+super.getHand().getCard(0)+" *");
        System.out.println("The second card is face down: ");
    }
}
