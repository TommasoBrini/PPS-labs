package tdd;

/**
 *  Task 3 - TDD for Circular Queue
 *  A simple CircularQueue that stores integers with a **fixed** capacity.
 *  When full, new elements overwrite the oldest ones.
 *  
 *  When removing elements, the oldest ones are removed first.
 *  Therefore, giving [4, 5, 3], the first element to be removed is 4, then 5, and finally 3.
 *  
 *  For the exercise: 
 *   - Think about the test cases you need to write.
 *   - Introduce methods in the interface in order to make the tests pass.
 *   - Refactor
 */
public interface CircularQueue {
    /**
     * Pushes an integer onto the queue.
     *
     * @param value The integer to push.
     */
    void push(int value);


    /**
     * Removes and returns the first element of the queue.
     *
     * @return The removed element.
     * @throws IllegalStateException if the queue is empty.
     */
    int remove();

    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Gets the number of elements currently in the queue.
     *
     * @return The current size of the queue.
     */
    int size();

}