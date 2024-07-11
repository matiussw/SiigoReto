package co.com.siigo.certification.utils;

public enum Headers {

    CONTENT_TYPE("Content-Type", "application/json");
    private String key;
    private String value;

    Headers(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
