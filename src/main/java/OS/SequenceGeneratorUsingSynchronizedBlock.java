package OS;

import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;

public class SequenceGeneratorUsingSynchronizedBlock extends SequenceGenerator {

    private Object mutex = new Object();

    @Override
    public int getNextSequence() {
        synchronized (mutex) {
            return super.getNextSequence();
        }
    }

    @Test
    public void givenUnsafeSequenceGenerator_whenSequenceGeneratorUsingSynchronizedBlock_thenExpectedBehavior() throws Exception {
        int count = 1000;
        Set<Integer> uniqueSequences = getUniqueSequences(new SequenceGeneratorUsingSynchronizedBlock(), count);
        assertEquals(count, uniqueSequences.size());
    }
}
