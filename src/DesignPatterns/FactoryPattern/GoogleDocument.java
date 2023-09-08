package DesignPatterns.FactoryPattern;

public class GoogleDocument implements IDocument {

    private String title;

    public GoogleDocument(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return this.title;
    }
}
