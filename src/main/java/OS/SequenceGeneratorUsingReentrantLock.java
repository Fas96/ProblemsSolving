package OS;

import org.junit.Test;

import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

import static org.junit.Assert.assertEquals;

public class SequenceGeneratorUsingReentrantLock extends SequenceGenerator {

    private ReentrantLock mutex = new ReentrantLock();

    @Override
    public int getNextSequence() {
        try {
            mutex.lock();
            return super.getNextSequence();
        } finally {
            mutex.unlock();
        }
    }

    @Test
    public void givenUnsafeSequenceGenerator_whenRaceCondition_thenExpectedBehavior() throws Exception {
        int count = 1000;
        Set<Integer> uniqueSequences = getUniqueSequences(new SequenceGeneratorUsingReentrantLock(), count);
        assertEquals(count, uniqueSequences.size());
    }
}