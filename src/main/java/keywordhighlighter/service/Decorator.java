package main.java.keywordhighlighter.service;

import main.java.keywordhighlighter.model.Word;

public abstract class Decorator {
    protected KeywordHolder keywordHolder;

    public Decorator(final KeywordHolder keywordHolder) {
        this.keywordHolder = keywordHolder;
    }

    /**
     * Method to decorate the text.
     *
     * @param word the word.
     * @return the decorated text.
     */
    public abstract String decorate(Word word);
}
