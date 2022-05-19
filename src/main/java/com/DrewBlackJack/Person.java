package com.DrewBlackJack;

public class Person {
    public static final String ANSI_BRIGHT_CYAN   = "\u001B[96m";
    public static final String ANSI_RESET  = "\u001B[33m";
    public static final String ANSI_RED    = "\u001B[31m";
    private String name;
    private Hand hand;

    public Person() {
        this.name = "";
        this.hand = new Hand();
    }
    public boolean hasBlackJack(){
        if(this.getHand().calculatedValue()==21){
            return true;
        }else{
            return false;
        }
    }
    public void printHand(){
        System.out.println(this.getName()+" was dealt the following hand:"+"\n");
        System.out.println(ANSI_BRIGHT_CYAN+this.getHand()+" For a total of: "+ this.getHand().calculatedValue()+ "\n"+ANSI_RESET);
    }
    public void hit(Deck deck, Deck discard){
        //Check  for no cards left in the deck
        if(!deck.hasCards()){
            deck.reloadDeckFromDiscard(discard);
        }
        this.hand.takeCardFromDeck(deck);
        System.out.println(this.getName() + " gets a card" +"\n");
        this.printHand();

    }

    public Hand getHand(){
        return this.hand;
    }
    public String getName(){
        return this.name;
    }
    //Sets a hand passed to it
    public void setHand(Hand hand){
        this.hand = hand;
    }
    //Sets the name passed to it
    public void setName(String name){
        this.name = name;
    }




}
