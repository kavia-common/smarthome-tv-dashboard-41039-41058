package org.example.app

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

/**
 * PUBLIC_INTERFACE
 * A JUnit 5 (Jupiter) parameterized test to guarantee discovery under the JUnit Platform.
 * This helps ensure at least one Jupiter test is present and executed by the test task.
 */
class JupiterDiscoveryTest {

    /**
     * PUBLIC_INTERFACE
     * Runs a simple assertion across multiple inputs.
     */
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3])
    fun numbers_arePositive(n: Int) {
        assertTrue(n > 0, "All provided numbers should be positive")
    }
}
