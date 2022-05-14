package com.DrewBlackJack;

public class Person {
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
        System.out.println(this.getName()+"'s hand are the following cards:"+"\n"+"\n");
        System.out.println(this.getHand()+" Valued at: "+ this.getHand().calculatedValue()+ "\n");
    }
    public void hit(Deck deck, Deck discard){
        //Check  for no cards left in the deck
        if(!deck.hasCards()){
            deck.reloadDeckFromDiscard(discard);
        }
        this.hand.takeCardFromDeck(deck);
        System.out.println(this.getName() + " gets a card" + "\n" +"\n");
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
