package DesignPatterns.SingeltonPattern;

public class RandomRecord {

    private static final RecordKeeper record = new RecordKeeper("value");
    private RandomRecord() {}
    public static RecordKeeper getInstance() {
        return record;
    }
}
