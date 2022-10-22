package com.gdstruc.midtermExam;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //initialize stacks needed
        CardStack playerDeck = new CardStack();
        CardStack playerHand = new CardStack();
        CardStack discardPile = new CardStack();

        //push all the cards to player deck (Tarot Cards)
        playerDeck.push(new Card("The Fool"));
        playerDeck.push(new Card("The Magician"));
        playerDeck.push(new Card("The High Priestess"));
        playerDeck.push(new Card("The Empress"));
        playerDeck.push(new Card("The Emperor"));
        playerDeck.push(new Card("The Hierophant"));
        playerDeck.push(new Card("The Lovers"));
        playerDeck.push(new Card("The Chariot"));
        playerDeck.push(new Card("Strength"));
        playerDeck.push(new Card("The Hermit"));
        playerDeck.push(new Card("The Wheel of Fortune"));
        playerDeck.push(new Card("Justice"));
        playerDeck.push(new Card("The Hanged Man"));
        playerDeck.push(new Card("Death"));
        playerDeck.push(new Card("Temperance"));
        playerDeck.push(new Card("The Devil"));
        playerDeck.push(new Card("The Tower"));
        playerDeck.push(new Card("The Star"));
        playerDeck.push(new Card("The Moon"));
        playerDeck.push(new Card("The Sun"));
        playerDeck.push(new Card("Judgement"));
        playerDeck.push(new Card("The World"));
        playerDeck.push(new Card("The Fool"));
        playerDeck.push(new Card("The Magician"));
        playerDeck.push(new Card("The High Priestess"));
        playerDeck.push(new Card("The Empress"));
        playerDeck.push(new Card("The Emperor"));
        playerDeck.push(new Card("The Hierophant"));
        playerDeck.push(new Card("The Lovers"));
        playerDeck.push(new Card("The Chariot"));

        int round = 1;
        System.out.println( "Current Status");
        playerHand.printPlayerHand();
        playerDeck.printPlayerDeck();
        discardPile.printDiscardPile();
        System.out.println( "\n");

        while (playerDeck.getSize() != 0)
        {
            System.out.println( "ROUND "+ round + "\n");
            Random rand = new Random();
            int option = 3;
            int randomOpt = rand.nextInt(option);
            Random rand2 = new Random();
            int amount = 5;
            int randomAmt = rand2.nextInt(amount);

            if (randomOpt == 0) {
                //draw cards from player deck
                if (playerDeck.getSize() < (randomAmt + 1))
                {
                    System.out.println("Draw " + (randomAmt + 1) + " card(s) from Player Deck \n");
                    System.out.println("Not enough cards in player deck. Will draw the remaining amount. \n");
                    while (!playerDeck.isEmpty()) {
                        playerDeck.command(playerHand);
                    }
                }
                else if (playerDeck.getSize() >= (randomAmt + 1))
                {
                    System.out.println("Draw " + (randomAmt + 1) + " card(s) from Player Deck \n");
                    for (int i = 0; i < (randomAmt + 1); i++) {
                        playerDeck.command(playerHand);
                    }
                }
            } else if (randomOpt == 1) {
                //discard cards
                if (playerHand.isEmpty())
                {
                    System.out.println("Discard " + (randomAmt + 1) + " card(s) from Hand \n");
                    System.out.println("No cards in hand to discard. \n");
                }
                else if (playerHand.getSize() < (randomAmt + 1))
                {
                    System.out.println("Discard " + (randomAmt + 1) + " card(s) from Hand \n");
                    System.out.println("Not enough cards in hand. Will discard remaining amount. \n");
                    while (!playerHand.isEmpty()) {
                        playerHand.command(discardPile);
                    }
                }
                else if (playerHand.getSize() >= (randomAmt + 1))
                {
                    System.out.println("Discard " + (randomAmt + 1) + " card(s) from Hand \n");
                    for (int i = 0; i < (randomAmt + 1); i++) {
                        playerHand.command(discardPile);
                    }
                }
            } else if (randomOpt == 2) {
                //Get cards from Discard Pile
                if (discardPile.isEmpty())
                {
                    System.out.println("Get " + (randomAmt + 1) + " card(s) from Discard Pile \n");
                    System.out.println("No cards in discard pile to get. \n");
                }
                else if (discardPile.getSize() < (randomAmt + 1))
                {
                    System.out.println("Get " + (randomAmt + 1) + " card(s) from Discard Pile \n");
                    System.out.println("Not enough cards in discard pile. Will get remaining amount. \n");
                    while (!discardPile.isEmpty()) {
                        discardPile.command(playerHand);
                    }
                }
                else if (discardPile.getSize() >= randomAmt + 1)
                {
                    System.out.println("Get " + (randomAmt + 1) + " card(s) from Discard Pile \n");
                    for (int i = 0; i < (randomAmt + 1); i++) {
                        discardPile.command(playerHand);
                    }
                }
            }
            System.out.println("CURRENT STATUS OF HAND, DECK & PILE: ");
            playerHand.printPlayerHand();
            playerDeck.printPlayerDeck();
            discardPile.printDiscardPile();
            System.out.println("\n");

            System.out.println("Enter anything to proceed to the next round");
            Scanner scanner = new Scanner(System.in);
            String decision = scanner.nextLine();
            if (decision == decision)
            {
                round++;
                continue;
            }

        }

        System.out.println("Player Deck is empty, the game is over.");
    }

}