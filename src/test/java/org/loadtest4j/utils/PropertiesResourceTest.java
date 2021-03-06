package org.loadtest4j.utils;

import org.loadtest4j.junit.IntegrationTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

@Category(IntegrationTest.class)
public class PropertiesResourceTest {
    @Test
    public void shouldSupplyProperties() {
        final PropertiesResource sut = new PropertiesResource("/props/example.properties");

        final Properties properties = sut.getProperties();

        final Properties expectedProperties = new Properties();
        expectedProperties.put("foo", "bar");
        assertThat(properties).isEqualTo(expectedProperties);
    }

    @Test
    public void shouldSupplyEmptyPropertiesByDefault() {
        final PropertiesResource sut = new PropertiesResource("/props/fake.properties");

        final Properties properties = sut.getProperties();

        assertThat(properties).isEqualTo(new Properties());
    }
}
