package OS;

import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;

public class SequenceGeneratorUsingSynchronizedMethod extends SequenceGenerator {

    @Override
    public synchronized int getNextSequence() {
        return super.getNextSequence();
    }

    @Test
    public void givenUnsafeSequenceGenerator_whenSequenceGeneratorUsingSynchronizedMethod_thenExpectedBehavior() throws Exception {
        int count = 1000;
        Set<Integer> uniqueSequences = getUniqueSequences(new SequenceGeneratorUsingSynchronizedMethod(), count);
        assertEquals(count, uniqueSequences.size());
    }

}
