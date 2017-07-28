package main.java.keywordhighlighter.service;

import main.java.keywordhighlighter.model.Keyword;
import main.java.keywordhighlighter.model.Word;

public class CaseDecorator extends Decorator {

    public CaseDecorator(final KeywordHolder keywordHolder) {
        super(keywordHolder);
    }

    /**
     * Method to decorate the text.
     *
     * @param word the text.
     * @return the decorated text.
     */
    @Override
    public String decorate(final Word word) {
        final String originalText = word.getOriginalText();
        final Keyword keyword = keywordHolder.getKeyword(originalText);
        if (keyword == null || keyword.getCaseStyle() == null) {
            return originalText;
        }
        final String caseStyle = keyword.getCaseStyle();
        final String decoratedText = word.getDecoratedText();
        if ("capital".equalsIgnoreCase(caseStyle)) {
            return decoratedText.toUpperCase();
        } else if ("lower".equalsIgnoreCase(caseStyle)) {
            return decoratedText.toLowerCase();
        } else {
            return originalText;
        }
    }
}
