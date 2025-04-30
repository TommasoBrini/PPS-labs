package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.model.SmartDoorLockImpl;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {

    private static final int PIN = 1234;
    private static final int WRONG_PIN = 4321;
    private static final int WRONG_ATTEMPTS = 4;
    private static final int RESET_ATTEMPTS = 0;

    private SmartDoorLock smartDoorLock;

    @BeforeEach
    public void setup(){
        this.smartDoorLock = new SmartDoorLockImpl();
        this.smartDoorLock.setPin(PIN);
    }

    @Test
    public void testErrorSetPin(){
        assertThrows(IllegalArgumentException.class, () -> this.smartDoorLock.setPin(0));
    }

    @Test
    public void testWrongStatus(){
        this.smartDoorLock.lock();
        assertThrows(IllegalStateException.class, () -> this.smartDoorLock.setPin(PIN));
    }

    @Test
    public void testLock(){
        this.smartDoorLock.lock();
        assertTrue(this.smartDoorLock.isLocked());
    }

    @Test
    public void testUnlock(){
        this.smartDoorLock.unlock(PIN);
        assertFalse(this.smartDoorLock.isLocked());
    }

    @Test
    public void testBlockedState(){
        this.blockDoor();
        assertTrue(this.smartDoorLock.isBlocked());
    }

    @Test
    public void testBlockedBehaviour(){
        this.blockDoor();
        this.smartDoorLock.lock();
        assertFalse(smartDoorLock.isLocked());
    }

    private void blockDoor(){
        for (int i = 0; i < WRONG_ATTEMPTS; i++) {
            this.smartDoorLock.unlock(WRONG_PIN);
        }
    }

    @Test
    public void testResetStatus(){
        this.blockDoor();
        this.smartDoorLock.reset();
        assertEquals(this.smartDoorLock.getFailedAttempts(), RESET_ATTEMPTS);
    }

}
