package DesignPatterns.SingeltonPattern;

public class RecordKeeper {
    private final String value;

    public RecordKeeper(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
