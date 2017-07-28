package test.java.keywordhighlighter.service;

import main.java.keywordhighlighter.model.Keyword;
import main.java.keywordhighlighter.model.Word;
import main.java.keywordhighlighter.service.CaseDecorator;
import main.java.keywordhighlighter.service.Decorator;
import main.java.keywordhighlighter.service.KeywordHolder;
import org.junit.Test;

public class CaseDecoratorTest {

    @Test
    public void shouldChangeTextCaseToCapital() {
        final KeywordHolder keywordHolder = new KeywordHolder();
        keywordHolder.addKeyword(new Keyword("if", "blue", "capital"));
        final Decorator decorator = new CaseDecorator(keywordHolder);
        final String inputText = "if";
        final Word word = new Word(inputText);
        final String expectedText = "IF";
        final String decoratedText = decorator.decorate(word);
        assert expectedText.equals(decoratedText);

    }
}
