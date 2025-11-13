package org.example.app;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 * PUBLIC_INTERFACE
 * A minimal JUnit4-style test to ensure discovery on default Android Gradle Plugin configurations.
 * This guarantees at least one test is executed by the :app unit test task.
 */
public class LegacyJUnit4Test {

    /**
     * PUBLIC_INTERFACE
     * Simple sanity test to validate test discovery and execution under JUnit4.
     */
    @Test
    public void sanityCheck() {
        assertTrue(true);
    }
}
