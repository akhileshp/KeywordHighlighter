package test.java.keywordhighlighter.service;

import main.java.keywordhighlighter.model.Keyword;
import main.java.keywordhighlighter.service.KeywordHolder;
import org.junit.Test;

public class KeywordHolderTest {

    @Test
    public void shouldReturnTrueForValidKeyword() {
        final KeywordHolder keywordHolder = new KeywordHolder();
        keywordHolder.addKeyword(new Keyword("as"));
        keywordHolder.addKeyword(new Keyword("if"));

        boolean isKeyword = keywordHolder.isKeyword("if");
        assert isKeyword;
    }
}
