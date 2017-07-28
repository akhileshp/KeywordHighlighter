package main.java.keywordhighlighter.model;

public class Word {

    private final String originalText;
    private String decoratedText;

    public Word(final String originalText) {
        this.originalText = originalText;
        this.decoratedText = originalText;
    }

    public String getOriginalText() {
        return originalText;
    }

    public String getDecoratedText() {
        return decoratedText;
    }

    public void setDecoratedText(final String decoratedText) {
        this.decoratedText = decoratedText;
    }
}
