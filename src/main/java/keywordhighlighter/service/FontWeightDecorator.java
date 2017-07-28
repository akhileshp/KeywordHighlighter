package main.java.keywordhighlighter.service;

import main.java.keywordhighlighter.model.Keyword;
import main.java.keywordhighlighter.model.Word;

public class FontWeightDecorator extends Decorator {

    public FontWeightDecorator(final KeywordHolder keywordHolder) {
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
        if (keyword == null || keyword.getFontWeight() == null) {
            return originalText;
        }
        final String fontWeight = keyword.getFontWeight();
        if ("bold".equalsIgnoreCase(fontWeight)) {
            return "[bold]" + word.getDecoratedText() + "[bold]";
        }
        return originalText;
    }
}
