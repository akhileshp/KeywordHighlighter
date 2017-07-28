package main.java.keywordhighlighter.service;

import main.java.keywordhighlighter.model.Word;

import java.util.ArrayList;
import java.util.List;

public class KeywordHighlighter {

    private KeywordHolder keywordHolder;
    private List<Decorator> decoratorList;


    public KeywordHighlighter(final KeywordHolder keywordHolder, final Decorator... decorators) {
        this.keywordHolder = keywordHolder;
        if (decorators != null && decorators.length > 0) {
            decoratorList = new ArrayList<>();
            for (final Decorator decorator : decorators) {
                decoratorList.add(decorator);
            }
        }
    }


    /**
     * Method to process the text.
     *
     * @param inputText the input text.
     * @return the processed text.
     */
    public String processText(final String inputText) {
        final String[] inputTextArray = inputText.split(" ");
        final StringBuilder stringBuilder = new StringBuilder();
        for (final String textWord : inputTextArray) {
            if (keywordHolder.isKeyword(textWord) && decoratorList != null && !decoratorList.isEmpty()) {
                final Word word = new Word(textWord);
                String decoratedText = textWord;
                for (final Decorator decorator : decoratorList) {
                    decoratedText = decorator.decorate(word);
                    word.setDecoratedText(decoratedText);
                }
                addToOutputString(stringBuilder, decoratedText);

            } else {
                addToOutputString(stringBuilder, textWord);
            }
        }
        return stringBuilder.toString();
    }

    /**
     * Method to add the text to output text. Append space if it is not first element.
     *
     * @param stringBuilder
     * @param text
     */
    private void addToOutputString(final StringBuilder stringBuilder, final String text) {
        if (stringBuilder.length() == 0) {
            stringBuilder.append(text);
        } else {
            stringBuilder.append(" " + text);
        }
    }

}
