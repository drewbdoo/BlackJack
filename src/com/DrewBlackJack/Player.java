package com.DrewBlackJack;

import java.util.Scanner;

public class Player extends Person {
    Scanner scan = new Scanner(System.in);

    public Player(String name){
        super.setName(name);

    }

    public void makeDecision(Deck deck, Deck discard) throws InterruptedException {
        int decision = 0;
        boolean getNum = true;
        while (getNum){
            try{
                System.out.println("What would you like to do now?");
                System.out.println("1) Hit ");
                System.out.println("or");
                System.out.println("2) Stay");
                decision = scan.nextInt();
                getNum=false;
            }catch (Exception e){
                System.out.println("Invalid option");
                scan.next();
            }
        }
        Thread.sleep(1000);
        System.out.println("You selected " + decision +"\n");
        Thread.sleep(1000);
        if(decision==1){
            this.hit(deck, discard);
            //Check to see if they hit blackjack or busted
            if(this.getHand().calculatedValue()>20){
                return;
                //let them go again if not 21 or busted
                }else{
                this.makeDecision(deck, discard);
            }
        }else{
            Thread.sleep(1000);
            System.out.println("You stand." + "\n");
            Thread.sleep(1000);
        }
    }
}
