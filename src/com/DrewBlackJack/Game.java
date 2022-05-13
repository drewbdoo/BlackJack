package com.DrewBlackJack;

public class Game {
    private int wins, losses, pushes;

    private Deck deck, discarded;
    private Dealer dealer;
    private Player player;


    public Game(String name){
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

    private void startRound(){
        //Dealer gets two cards
        dealer.getHand().takeCardFromDeck(deck);
        dealer.getHand().takeCardFromDeck(deck);
        //Player gets two cards
        player.getHand().takeCardFromDeck(deck);
        player.getHand().takeCardFromDeck(deck);
        //Print their hands
        dealer.printFirstHand();
        player.printHand();
        if(dealer.hasBlackJack()){
            //show that the dealer has blackjack to start
            dealer.printHand();
            //Check if player also has blackjack
            if(player.hasBlackJack()){
                System.out.println("You both have 21 - Push.");
                pushes++;
                startRound();
            }else{
                System.out.println("Dealer has BlackJack. You lose");
                dealer.printHand();
                losses++;
                startRound();
            }
        }
        //Check if player has blackjack to start
        if(player.hasBlackJack()){
            System.out.println("You have BlackJack! You win!");
            wins++;
            startRound();
        }
        player.makeDecision(deck, discarded);
        if(player.getHand().calculatedValue()>21){
            System.out.println("You hand is over 21. BUSTED!");
            losses++;
            //restart the round
            startRound();
        }



    }









}
