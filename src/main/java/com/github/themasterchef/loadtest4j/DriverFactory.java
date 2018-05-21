package com.github.themasterchef.loadtest4j;

import java.util.Map;
import java.util.Set;

public interface DriverFactory {
    Set<String> getMandatoryProperties();

    Driver create(Map<String, String> properties);
}