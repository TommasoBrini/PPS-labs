package tdd.model;

import tdd.SmartDoorLock;

public class SmartDoorLockImpl implements SmartDoorLock {

    private enum Status{
        LOCKED, UNLOCKED, BLOCKED
    }

    private static final int DEFAULT_PIN = 0;
    private static final int PIN_LENGTH = 4;
    private static final int INITIAL_ATTEMPTS = 0;
    private static final int MAX_ATTEMPTS = 3;

    private int pin;
    private Status status;
    private int attempts;

    public SmartDoorLockImpl(){
        this.reset();
    }

    @Override
    public void setPin(int pin) {
        if(!this.isLocked() && !this.isBlocked()){
            if(this.checkPin(pin)){
                throw new IllegalArgumentException("Pin must be 4-digit number");
            }
            this.pin = pin;
        } else {
            throw new IllegalStateException("Door is locked or blocked");
        }
    }

    private boolean checkPin(int pin){
        return String.valueOf(pin).length() != PIN_LENGTH;
    }


    @Override
    public void unlock(int pin) {
        if(!this.isBlocked()){
            if (this.pin == pin){
                this.attempts = INITIAL_ATTEMPTS;
                this.status = Status.UNLOCKED;
            } else {
                this.fail();
            }
        }
    }

    private void fail(){
        this.attempts += 1;
        if(this.attempts > MAX_ATTEMPTS){
            this.status = Status.BLOCKED;
        }
    }

    @Override
    public void lock() {
        if(!this.isBlocked()){
            if(pin != DEFAULT_PIN){
                this.status = Status.LOCKED;
            } else {
                throw new IllegalStateException("Pin is not set");
            }
        }

    }

    @Override
    public boolean isLocked() {
        return this.status == Status.LOCKED;
    }

    @Override
    public boolean isBlocked() {
        return this.status == Status.BLOCKED;
    }

    @Override
    public int getMaxAttempts() {
        return MAX_ATTEMPTS;
    }

    @Override
    public int getFailedAttempts() {
        return this.attempts;
    }

    @Override
    public void reset() {
        this.attempts = INITIAL_ATTEMPTS;
        this.status = Status.UNLOCKED;
        this.pin = DEFAULT_PIN;
    }
}
