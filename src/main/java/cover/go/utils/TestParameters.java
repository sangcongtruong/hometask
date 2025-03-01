package cover.go.utils;

import java.util.Properties;

public class TestParameters {
    private final Properties testVariables;

    private final String host;
    private final String user;
    private final String password;
    private final String browser;

    public TestParameters(Properties testVariables) {
        this.testVariables = testVariables;
        host = loadProperty("host");
        user = loadProperty("user");
        password = loadProperty("password");
        browser = loadProperty("browser");
    }

    /**
     * Retrieves the property value associated with the specified key.
     * First, it attempts to obtain the property from System properties
     * (which is useful for CI/CD integration). If not found or empty,
     * it falls back to the properties loaded from the file.
     *
     * @param propertyKey
     * @return value of required property
     */
    public String loadProperty(String propertyKey) {
        String property = System.getProperty(propertyKey);
        if (property != null && !property.isEmpty()) {
            return property;
        }
        return testVariables.getProperty(propertyKey);
    }

    public String getHost() {
        return host;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getBrowser(){
        return browser;
    }
}
