package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.model.CircularQueueImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private static final int SIZE = 3;
    private CircularQueue circularQueue;

    @BeforeEach
    public void setup(){
        this.circularQueue = new CircularQueueImpl(SIZE);
    }

    private void populate(int size){
        for (int i = 0; i < size; i++) {
            this.circularQueue.push(i);
        }
    }

    @Test
    public void testEmpty(){
        assertTrue(this.circularQueue.isEmpty());
    }

    @Test
    public void testPush() {
        this.circularQueue.push(1);
        assertEquals(1, this.circularQueue.size());
    }

    @Test
    public void testRemove() {
        this.populate(SIZE);
        assertEquals(0, this.circularQueue.remove());
    }

    @Test
    public void testPushMoreElement() {
        this.populate(SIZE + 3);
        assertEquals(3, this.circularQueue.remove());
    }

}