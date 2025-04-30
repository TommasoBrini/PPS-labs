package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.model.MinMaxStackImpl;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {

    private static final int INITIAL_SIZE = 5;
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = INITIAL_SIZE - 1;

    private MinMaxStack minMaxStack;

    @BeforeEach
    public void setup(){
        this.minMaxStack = new MinMaxStackImpl();
        this.populate();
    }

    private void populate(){
        for(int i = MIN_VALUE; i < INITIAL_SIZE; i++){
            this.minMaxStack.push(i);
        }
    }

    @Test
    public void testEmpty() {
        assertFalse(this.minMaxStack.isEmpty());
    }

    @Test
    public void testPop() {
        assertAll(() -> assertEquals(INITIAL_SIZE - 1, this.minMaxStack.pop()), () -> assertEquals(INITIAL_SIZE - 1, this.minMaxStack.size()));
    }

    @Test
    public void testPeek() {
        assertAll(() -> assertEquals(INITIAL_SIZE - 1, this.minMaxStack.peek()), () -> assertEquals(INITIAL_SIZE, this.minMaxStack.size()));
    }

    private void clearStack() {
        for (int i = 0; i < INITIAL_SIZE; i++){
            this.minMaxStack.pop();
        }
    }

    @Test
    public void testPopEmptyStack() {
        this.clearStack();
        assertThrowsExactly(IllegalStateException.class, () -> this.minMaxStack.pop());
    }

    @Test
    public void testMin(){
        assertEquals(MIN_VALUE, this.minMaxStack.getMin());
        this.clearStack();
        assertThrowsExactly(IllegalStateException.class, () -> this.minMaxStack.getMin());
    }

    @Test
    public void testMax(){
        assertEquals(MAX_VALUE, this.minMaxStack.getMax());
        this.clearStack();
        assertThrowsExactly(IllegalStateException.class, () -> this.minMaxStack.getMin());
    }

    @Test
    public void testMaxAfterPop(){
        this.minMaxStack.pop();
        assertEquals(MAX_VALUE - 1, minMaxStack.getMax());
    }

    @Test
    public void testMinAfterPop(){
        this.clearStack();
        this.minMaxStack.push(2);
        this.minMaxStack.push(5);
        this.minMaxStack.push(0);
        this.minMaxStack.pop();
        assertEquals(2, this.minMaxStack.getMin());
    }
}