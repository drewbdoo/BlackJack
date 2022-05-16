package com.DrewBlackJack;

import java.sql.SQLOutput;

public class Dealer extends Person {

    public Dealer(){
        //Sets the name to "Dealer"
        super.setName("Dealer");
    }

    //Shows the dealer's first hand
    public void printFirstHand() throws InterruptedException {
        System.out.println("\n" + "The dealer deals himself and you two cards. " + "\n");
        Thread.sleep(1000);
        System.out.println("You see he is showing"+"\n");
        System.out.println(ANSI_BRIGHT_CYAN+"* "+super.getHand().getCard(0)+" *"+ANSI_RESET);
        System.out.println(ANSI_RED+"\n"+"His second card remains hidden" + "\n"+ANSI_RESET);
    }
}
