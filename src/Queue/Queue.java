package Queue;

/**
 * Queue.java
 *
 * Your Name:       Ferzan
 * Your Student ID:  240444049
 */
public class Queue<T> {

    private T[] items;
    private int front; // first element of the queue
    private int rear;  // last element of the queue
    private int count;

    @SuppressWarnings("unchecked")
    public Queue(int capacity) {
        items = (T[]) new Object[capacity];

        front = 0;
        rear = -1;
        count = 0;
    }

    public void enqueue(T value) {
        // Step 1: Check whether the queue is full.
        if (isFull()) {
            throw new IllegalStateException("Queue is full. Cannot enqueue: " + value);
        }

        // Step 2: Calculate the next rear position.
        rear++;

        // Step 3: Insert the new element into the array.
        items[rear] = value;

        // Step 4: Increase count.
        count++;
    }

    public T dequeue() {
        // Check whether the queue is empty.
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty. Cannot dequeue.");
        }

        //  Store the element at the front position.
        T removedValue = items[front];

        //Clear reference to help garbage collection and move front to the next position.
        items[front] = null;
        front++;

        // Decrease count.
        count--;

        // Return the removed element.
        return removedValue;
    }

    public T peek() {
        //  Check whether the queue is empty.
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty. Cannot peek.");
        }

        //  Return the front element without removing it.
        return items[front];
    }

    public boolean isEmpty() {
        //  Check whether count is zero.
        return count == 0;
    }

    public boolean isFull() {
        //  Check whether count equals the array capacity.
        return count == items.length;
    }

    public int size() {
        //  Return the number of elements.
        return count;
    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder("[");

        for (int i = 0; i < count; i++) {

            int index = front + i;

            result.append(items[index]);

            if (i < count - 1) {
                result.append(", ");
            }
        }

        result.append("]");

        return result.toString();
    }

}