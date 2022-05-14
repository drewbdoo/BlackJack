package com.DrewBlackJack;

import java.sql.SQLOutput;

public class Dealer extends Person {

    public Dealer(){
        //Sets the name to "Dealer"
        super.setName("Dealer");
    }

    //Shows the dealer's first hand
    public void printFirstHand() throws InterruptedException {
        System.out.println("\n" + "The dealer deals himself and you two cards. " + "\n" + "\n");
        Thread.sleep(1000);
        System.out.println("You see he is showing"+"\n");
        System.out.println("* "+super.getHand().getCard(0)+" *");
        System.out.println("\n"+"His second card remains hidden" + "\n");
    }
}
