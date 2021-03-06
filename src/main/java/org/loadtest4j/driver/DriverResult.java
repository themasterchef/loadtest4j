package org.loadtest4j.driver;

import java.time.Duration;

/**
 * The low-level results from the load test driver.
 */
public interface DriverResult {
    long getOk();

    long getKo();

    Duration getActualDuration();

    DriverResponseTime getResponseTime();
}
