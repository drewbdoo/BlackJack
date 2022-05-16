package com.DrewBlackJack;

import java.util.Scanner;

public class Game {
    Scanner scanner = new Scanner(System.in);
    private int wins, losses, pushes, totalPot, playerPot, currentBet, playerBet;


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

        playerPot = 500;
        totalPot = 0;
        currentBet = 0;
        wins = 0;
        losses = 0;
        pushes = 0;
        playerBet = 0;
        startRound();
    }

    private void startRound() throws InterruptedException {

        if (wins > 0 || losses > 0 || pushes > 0) {
            System.out.println();
            System.out.println("Starting Next Round....");
            System.out.println("Wins: "+wins);
            System.out.println("Losses: "+losses);
            System.out.println("Pushes: "+pushes);
            System.out.println("Your current pot is $"+playerPot);
            dealer.getHand().discardHandToDeck(discarded);
            player.getHand().discardHandToDeck(discarded);
        }
        if(playerPot<=0){
            System.out.println("I'm sorry, but you appear to be out of money.");
            System.out.println("You are escorted out of the casino and asked to return if and when you have money again.");
            System.exit(0);
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

        boolean loopVar = true;
        do{
            System.out.println("How much would you like to bet?.");
            System.out.println("Warning! The casino only accepts bets in increments of $5");
            String bets = scanner.nextLine();
            int bet = Integer.parseInt(bets);
            if(bet%5!=0){
                System.out.println("I'm sorry, that is not a multiple of $5");
            }else{
                betToPot(bet);
                loopVar=false;
            }
        }while(loopVar);

        System.out.println("The current total in the pot is $"+totalPot);
        System.out.println("You current pot is $"+ playerPot);
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
                tieBet();
                startRound();
            }else{
                System.out.println("Dealer has BlackJack. You lose");
                Thread.sleep(3000);
                dealer.printHand();
                losses++;
                dealerWinPot();
                startRound();
            }
        }
        //Check if player has blackjack to start
        if(player.hasBlackJack()){
            System.out.println("You have BlackJack! You win!");
            Thread.sleep(3000);
            wins++;
            playerWinPot();
            startRound();
        }
        doubleDown();
        player.makeDecision(deck, discarded);

        if(player.getHand().calculatedValue()>21){
            System.out.println("You hand is over 21. BUSTED!");
            Thread.sleep(3000);
            losses++;
            dealerWinPot();
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
            playerWinPot();
            wins++;
        } else if (dealer.getHand().calculatedValue() > player.getHand().calculatedValue()) {
            System.out.println("You loose, sowwy.");
            losses++;
            dealerWinPot();
            Thread.sleep(3000);
        }else if(player.getHand().calculatedValue()>dealer.getHand().calculatedValue()){
            System.out.println("Congrats! You win!");
            Thread.sleep(3000);
            playerWinPot();
            wins++;
        }else{
            System.out.println("It's a tie - Push.");
            tieBet();
            Thread.sleep(3000);
        }
        startRound();



    }



    private void doubleDown() {
        System.out.println("Would you like to double down?");
        System.out.println("1) Yes");
        System.out.println("2) No");
        String bet = scanner.nextLine();
        if(bet.equals("1")){
            currentBet = currentBet * 2;
            }else{
            System.out.println("You stay with your current bet");
        }

    }

    private void playerWinPot() {
        playerPot = playerPot + totalPot;
    }

    private void dealerWinPot() {
        totalPot=0;
    }

    private void betToPot(int x) {
       totalPot += x;
       playerPot -=x;
       currentBet +=x;
    }
    private void tieBet() {
    playerPot= playerPot+currentBet;
    }



}
