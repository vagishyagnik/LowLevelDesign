package DesignPatterns.FactoryPattern;

public class WordDocument implements IDocument {

    private String title;

    public WordDocument(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return this.title;
    }
}
