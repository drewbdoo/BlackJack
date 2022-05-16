package com.DrewBlackJack;

import java.util.Scanner;

public class Game {
    public static final String ANSI_RESET  = "\u001B[33m";
    public static final String ANSI_GREEN  = "\u001B[32m";
    public static final String ANSI_RED    = "\u001B[31m";
    public static final String ANSI_BLUE   = "\u001B[34m";

    Scanner scanner = new Scanner(System.in);
    private int wins, losses, pushes, totalPot, playerPot, currentBet;


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
        startRound();
    }

    private void startRound() throws InterruptedException {

        if (wins > 0 || losses > 0 || pushes > 0) {
            System.out.println();
            System.out.println("Starting Next Round...."+"\n");
            System.out.println("Wins: "+ ANSI_RED+wins+ANSI_RESET);
            System.out.println("Losses: "+ANSI_GREEN+losses+ANSI_RESET);
            System.out.println("Pushes: "+ANSI_BLUE+pushes+ANSI_RESET+"\n");
            System.out.println("Your current pot is " + ANSI_GREEN+"$"+playerPot+ANSI_RESET+"\n");
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
            System.out.println("How much would you like to bet?"+"\n");
            System.out.println("Warning! The casino only accepts bets in increments of" +ANSI_GREEN+" $5"+ANSI_RESET);
            String bets = scanner.nextLine();
            int bet = Integer.parseInt(bets);
            if(bet%5!=0){
                System.out.println("I'm sorry, that is not a multiple of $5"+"\n");
            }else{
                betToPot(bet);
                loopVar=false;
            }
        }while(loopVar);
        Thread.sleep(1000);
        System.out.println("The current total in the pot is "+ANSI_GREEN+"$"+totalPot+"\n"+ANSI_RESET);
        System.out.println("You current pot is "+ANSI_GREEN+"$"+ playerPot+ANSI_RESET);
        Thread.sleep(500);
        //Print their hands
        dealer.printFirstHand();
        Thread.sleep(500);
        player.printHand();
        Thread.sleep(1000);
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
                System.out.println("Dealer has BlackJack. " + ANSI_RED+"You lose!!"+ANSI_RESET);
                Thread.sleep(3000);
                losses++;
                dealerWinPot();
                startRound();
            }
        }
        //Check if player has blackjack to start
        if(player.hasBlackJack()){
            System.out.println("You have BlackJack! "+ANSI_GREEN+"You win!"+ANSI_RESET);
            Thread.sleep(3000);
            wins++;
            playerWinPot();
            startRound();
        }
        doubleDown();
        Thread.sleep(500);
        player.makeDecision(deck, discarded);

        if(player.getHand().calculatedValue()>21){
            System.out.println("You hand is over 21. "+ANSI_RED+"BUSTED!"+ANSI_RESET);
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
            Thread.sleep(500);
        }
        //Check who wins
        if(dealer.getHand().calculatedValue()>21){
            System.out.println(ANSI_RED+"Dealer busts!!!!!!"+ANSI_RESET);
            Thread.sleep(3000);
            playerWinPot();
            wins++;
        } else if (dealer.getHand().calculatedValue() > player.getHand().calculatedValue()) {
            System.out.println(ANSI_RED+"You loose, sowwy :("+ANSI_RESET);
            losses++;
            dealerWinPot();
            Thread.sleep(3000);
        }else if(player.getHand().calculatedValue()>dealer.getHand().calculatedValue()){
            System.out.println("Congrats! "+ANSI_GREEN+"You win!"+ANSI_RESET);
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



    private void doubleDown() throws InterruptedException {
        System.out.println("Would you like to double down?");
        System.out.println("1) Yes");
        System.out.println("2) No");
        String bet = scanner.nextLine();
        Thread.sleep(1000);
        if(bet.equals("1")){
            System.out.println("You decide to double down!"+"\n");
            Thread.sleep(500);
            doubleBet();
            System.out.println("Your new bet is $"+ANSI_GREEN+totalPot+ANSI_RESET);
            }else{
            Thread.sleep(500);
            System.out.println("You stay with your current bet"+"\n");
        }

    }

    private void doubleBet() {
        playerPot=playerPot-currentBet;
        totalPot=currentBet*2;
    }

    private void playerWinPot() {
        playerPot = playerPot + (totalPot*2);
        currentBet=0;
    }

    private void dealerWinPot() {
        totalPot=0;
        currentBet=0;
    }

    private void betToPot(int x) {
       totalPot += x;
       playerPot -= x;
       currentBet += x;
    }
    private void tieBet() {
    playerPot = playerPot+currentBet;
    currentBet=0;
    }



}
