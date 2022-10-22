package com.gdstruc.midtermExam;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.ListIterator;

// wrapper class to limit the LinkedList class into Stack operations
public class CardStack {
    private LinkedList<Card> stack;

    public CardStack() {
        stack = new LinkedList<>();
    }

    public void push(Card card) {
        stack.push(card);
    }

    public Card pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return stack.pop();
    }

    public Card peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void printPlayerDeck() {
        System.out.println("Number of Cards in Player Deck: " + stack.size());
    }

    public void printPlayerHand() {
        System.out.println("Cards in Player Hand: (" + stack.size() + " cards)");

        ListIterator<Card> iterator = stack.listIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void printDiscardPile() {
        System.out.println("Number of Cards in Discard Pile: " + stack.size());
    }

    public void command(CardStack receiver)
    {
        receiver.push(stack.pop());
    }

    public int getSize()
    {
        return stack.size();
    }


}
