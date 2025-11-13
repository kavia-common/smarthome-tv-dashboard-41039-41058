package org.example.app

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * PUBLIC_INTERFACE
 * A JUnit 5 (Jupiter) test to ensure the :app unit test task discovers and executes at least one test.
 * This aligns with the project-level defaults that include JUnit Jupiter dependencies.
 */
class DiscoveryCheckTest {

    /**
     * PUBLIC_INTERFACE
     * Simple assertion to validate test execution under JUnit Jupiter.
     */
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}
