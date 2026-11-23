package PalindromeStack;

/**
 * Stack.java
 *
 * Your Name:        ferzan
 * Your Student ID:  240444049
 */

public class Stack {

    private char[] items;
    private int top;

    public Stack(int capacity) {
        items = new char[capacity];

        // Initialize top to indicate an empty stack.
        top = -1;
    }

    public void push(char value) {
        // Step 1: Check whether the stack is full.
        if (isFull()) {
            throw new IllegalStateException("Stack is full. Cannot push: " + value);
        }

        // Step 2: Increase top.
        top++;

        // Step 3: Insert the character at the top position.
        items[top] = value;
    }

    public char pop() {
        // Step 1: Check whether the stack is empty.
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty. Cannot pop.");
        }

        // Step 2: Store the character at the top position.
        char removedChar = items[top];

        // Step 3: Decrease top.
        top--;

        // Step 4: Return the removed character.
        return removedChar;
    }

    public char peek() {
        // Check whether the stack is empty.
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty. Cannot peek.");
        }

        // Return the character at the top without removing it.
        return items[top];
    }

    public boolean isEmpty() {
        // Return true if the stack is empty.
        return top == -1;
    }

    public boolean isFull() {
        // Return true if the stack is full.
        return top == items.length - 1;
    }
}