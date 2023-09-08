package DesignPatterns.FactoryPattern;

public enum Document {
    WORD {
        @Override
        public IDocument getInstance(String title) {
            return new WordDocument(title);
        }
    }, GOOGLE {
        @Override
        public IDocument getInstance(String title) {
            return new GoogleDocument(title);
        }
    };
    public abstract IDocument getInstance(String title);
}
