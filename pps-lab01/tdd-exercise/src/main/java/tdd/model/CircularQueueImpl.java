package tdd.model;

import tdd.CircularQueue;

import java.util.ArrayList;
import java.util.List;

public class CircularQueueImpl implements CircularQueue {

    private static final int INDEX_TO_REMOVED = 0;
    private final List<Integer> queue;
    private final int maxSize;

    public CircularQueueImpl(int size) {
        this.maxSize = size;
        this.queue = new ArrayList<>();
    }

    @Override
    public void push(int value) {
        this.checkSize();
        this.queue.add(value);
    }

    private void checkSize(){
        if(this.size() == this.maxSize){
            this.remove();
        }
    }

    @Override
    public int remove() {
        if (this.isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }
        return this.queue.remove(INDEX_TO_REMOVED);
    }

    @Override
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override
    public int size() {
        return this.queue.size();
    }

}