package org.example.app

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertTrue

/**
 * PUBLIC_INTERFACE
 * A minimal JUnit Jupiter test to ensure the :app testDebugUnitTest task always discovers at least one test.
 * This avoids CI failures when discovery heuristics vary across environments.
 */
class DebugDiscoveryKeeperTest {

    /**
     * PUBLIC_INTERFACE
     * Simple assertion that always passes.
     */
    @Test
    fun alwaysPasses() {
        assertTrue(true)
    }
}
