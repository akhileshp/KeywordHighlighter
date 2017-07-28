package main.java.keywordhighlighter.service;

import main.java.keywordhighlighter.model.Keyword;

import java.util.Map;
import java.util.TreeMap;

public class KeywordHolder {
    private final Map<String, Keyword> keywordMap;

    public KeywordHolder() {
        keywordMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    }

    /**
     * Method to add the keyword to collection.
     *
     * @param keyword the specified keyword.
     */
    public void addKeyword(final Keyword keyword) {
        keywordMap.put(keyword.getValue(), keyword);
    }

    /**
     * Method to check if the specified word is a keyword.
     *
     * @param word the word.
     * @return true if the word is a keyword. Otherwise return false.
     */
    public boolean isKeyword(final String word) {
        return keywordMap.containsKey(word);
    }

    /**
     * Method to get the keyword.
     *
     * @param text the text.
     * @return
     */
    public Keyword getKeyword(final String text) {
        return keywordMap.get(text);
    }
}
