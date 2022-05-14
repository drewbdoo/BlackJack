package com.DrewBlackJack;

public class Dealer extends Person {

    public Dealer(){
        //Sets the name to "Dealer"
        super.setName("Dealer");
    }

    //Shows the dealer's first hand
    public void printFirstHand(){
        System.out.println("\n" + "The dealer deals himself and you two cards. " + "\n" + "\n"+
                "You see he is showing"+"\n"+"\n");
        System.out.println("* "+super.getHand().getCard(0)+" *");
        System.out.println("\n"+"His second card remains hidden" + "\n");
    }
}
