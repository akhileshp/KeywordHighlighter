package test.java.keywordhighlighter.service;

import main.java.keywordhighlighter.model.Keyword;
import main.java.keywordhighlighter.model.Word;
import main.java.keywordhighlighter.service.Decorator;
import main.java.keywordhighlighter.service.FontWeightDecorator;
import main.java.keywordhighlighter.service.KeywordHolder;
import org.junit.Test;

public class FontWeightDecoratorTest {

    @Test
    public void shouldChangeTextFontWeightToBold() {
        final KeywordHolder keywordHolder = new KeywordHolder();
        keywordHolder.addKeyword(new Keyword("if", "blue", "capital", "bold"));
        final Decorator decorator = new FontWeightDecorator(keywordHolder);
        final String inputText = "if";
        final Word word = new Word(inputText);
        final String expectedText = "[bold]if[bold]";
        final String decoratedText = decorator.decorate(word);
        assert expectedText.equals(decoratedText);

    }
}
