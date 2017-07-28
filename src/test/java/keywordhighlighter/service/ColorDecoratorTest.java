package test.java.keywordhighlighter.service;

import main.java.keywordhighlighter.model.Keyword;
import main.java.keywordhighlighter.model.Word;
import main.java.keywordhighlighter.service.ColorDecorator;
import main.java.keywordhighlighter.service.Decorator;
import main.java.keywordhighlighter.service.KeywordHolder;
import org.junit.Test;

public class ColorDecoratorTest {

    @Test
    public void shouldHighlightTextInBlueColor() {
        final KeywordHolder keywordHolder = new KeywordHolder();
        keywordHolder.addKeyword(new Keyword("if", "blue"));
        final Decorator colorDecorator = new ColorDecorator(keywordHolder);
        final String inputText = "if";
        final Word word = new Word(inputText);
        final String expectedText = "[blue]if[blue]";
        final String decoratedText = colorDecorator.decorate(word);
        assert expectedText.equals(decoratedText);

    }
}
