package com.DrewBlackJack;

import java.sql.SQLOutput;

public class Game {
    private int wins, losses, pushes;

    private Deck deck, discarded;
    private Dealer dealer;
    private Player player;


    public Game(String name) throws InterruptedException {
        //Generate a new deck of 52
        deck = new Deck(true);
        //Make an empty deck for the discarded cards
        discarded = new Deck();
        //Make the player and dealer
        dealer = new Dealer();
        player = new Player(name);
        //Shuffle the deck at start of first round
        deck.shuffle();
        startRound();

        wins = 0;
        losses = 0;
        pushes = 0;
    }

    private void startRound() throws InterruptedException {
        if (wins > 0 || losses > 0 || pushes > 0) {
            System.out.println();
            System.out.println("Starting Next Round....");
            System.out.println("Wins: "+wins);
            System.out.println("Losses: "+losses);
            System.out.println("Pushes: "+pushes);
            dealer.getHand().discardHandToDeck(discarded);
            player.getHand().discardHandToDeck(discarded);
        }
        //Make sure there are at least 4 cards left in deck
        if(deck.cardsLeft()<4){
            deck.reloadDeckFromDiscard(discarded);
        }
        //Dealer gets two cards
        dealer.getHand().takeCardFromDeck(deck);
        dealer.getHand().takeCardFromDeck(deck);
        //Player gets two cards
        player.getHand().takeCardFromDeck(deck);
        player.getHand().takeCardFromDeck(deck);
        //Print their hands
        dealer.printFirstHand();
        player.printHand();
        //Check to see if dealer has blackjack to start
        if(dealer.hasBlackJack()){
            //show that the dealer has blackjack to start
            dealer.printHand();
            //Check if player also has blackjack
            if(player.hasBlackJack()){
                System.out.println("You both have 21 - Push.");
                Thread.sleep(3000);
                pushes++;
                startRound();
            }else{
                System.out.println("Dealer has BlackJack. You lose");
                Thread.sleep(3000);
                dealer.printHand();
                losses++;
                startRound();
            }
        }
        //Check if player has blackjack to start
        if(player.hasBlackJack()){
            System.out.println("You have BlackJack! You win!");
            Thread.sleep(3000);
            wins++;
            startRound();
        }
        player.makeDecision(deck, discarded);

        if(player.getHand().calculatedValue()>21){
            System.out.println("You hand is over 21. BUSTED!");
            Thread.sleep(3000);
            losses++;
            //restart the round
            startRound();
        }
        //dealer's round
        dealer.printHand();
        while(dealer.getHand().calculatedValue()<17){
            dealer.hit(deck,discarded);
        }
        //Check who wins
        if(dealer.getHand().calculatedValue()>21){
            System.out.println("Dealer busts!");
            Thread.sleep(3000);
            wins++;
        } else if (dealer.getHand().calculatedValue() > player.getHand().calculatedValue()) {
            System.out.println("You loose, sowwy.");
            Thread.sleep(3000);
        }else if(player.getHand().calculatedValue()>dealer.getHand().calculatedValue()){
            System.out.println("Congrats! You win!");
            Thread.sleep(3000);
            wins++;
        }else{
            System.out.println("It's a tie - Push.");
            Thread.sleep(3000);
        }
        startRound();



    }









}
