package fr.inria.stamp.mutationtest.descartes;

import edu.emory.mathcs.backport.java.util.Arrays;
import org.junit.Test;
import org.pitest.functional.predicate.False;
import org.pitest.mutationtest.engine.MutationEngine;

import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;



public class DescartesEngineFactoryTest {

    @Test
    public void shouldCreateEngineWithMutators() throws Exception {
        String[] operators = {"void", "3", "null", "\"string\"", "'a'"};
        DescartesEngineFactory factory = new DescartesEngineFactory();
        MutationEngine engine = factory.createEngine(
                false,
                False.<String>instance(),
                Collections.<String>emptyList(),
                Arrays.asList(operators),
                false);
        Collection<String> collectedOperators = engine.getMutatorNames();

        assertThat(collectedOperators, hasSize(operators.length));
        assertThat(collectedOperators, contains(operators));
    }

}