package main.java.keywordhighlighter.service;

import main.java.keywordhighlighter.model.Keyword;
import main.java.keywordhighlighter.model.Word;

public class ColorDecorator extends Decorator {

    public ColorDecorator(final KeywordHolder keywordHolder) {
        super(keywordHolder);
    }

    /**
     * Method to decorate the text.
     *
     * @param word the word.
     * @return the decorated text.
     */
    @Override
    public String decorate(final Word word) {
        final String originalText = word.getOriginalText();
        final Keyword keyword = keywordHolder.getKeyword(originalText);
        if (keyword == null || keyword.getColor() == null) {
            return originalText;
        }
        final String color = keyword.getColor();
        String formattedColorElement = "[" + color + "]";
        return formattedColorElement + word.getDecoratedText() + formattedColorElement;
    }
}
