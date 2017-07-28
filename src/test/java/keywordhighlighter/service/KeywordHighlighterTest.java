package test.java.keywordhighlighter.service;

import main.java.keywordhighlighter.model.Keyword;
import main.java.keywordhighlighter.service.*;
import org.junit.Test;

public class KeywordHighlighterTest {

    @Test
    public void shouldHighlightKeywordsWithBlueColor() {
        final KeywordHolder keywordHolder = new KeywordHolder();
        keywordHolder.addKeyword(new Keyword("as", "blue"));
        keywordHolder.addKeyword(new Keyword("if", "blue"));
        keywordHolder.addKeyword(new Keyword("and", "blue"));
        keywordHolder.addKeyword(new Keyword("then", "blue"));
        keywordHolder.addKeyword(new Keyword("when", "blue"));

        final ColorDecorator colorDecorator = new ColorDecorator(keywordHolder);
        final KeywordHighlighter highlighter = new KeywordHighlighter(keywordHolder, colorDecorator);
        final String inputText = "If we write a program and compile it, then we can run the program to get output";
        final String expectedOutputText = "[blue]If[blue] we write a program [blue]and[blue] compile it, [blue]then[blue] we can run the program to get output";
        final String processedText = highlighter.processText(inputText);
        assert expectedOutputText.equals(processedText);
    }

    @Test
    public void shouldHighlightKeywordsWithAppropriateColors() {
        final KeywordHolder keywordHolder = new KeywordHolder();
        keywordHolder.addKeyword(new Keyword("as", "blue"));
        keywordHolder.addKeyword(new Keyword("if", "red"));
        keywordHolder.addKeyword(new Keyword("and", "red"));
        keywordHolder.addKeyword(new Keyword("then", "green"));
        keywordHolder.addKeyword(new Keyword("when", "blue"));

        final ColorDecorator colorDecorator = new ColorDecorator(keywordHolder);
        final KeywordHighlighter highlighter = new KeywordHighlighter(keywordHolder, colorDecorator);
        final String inputText = "If we write a program and compile it, then as we run the program, we will get output";
        final String expectedOutputText = "[red]If[red] we write a program [red]and[red] compile it, [green]then[green] [blue]as[blue] we run the program, we will get output";
        final String processedText = highlighter.processText(inputText);
        assert expectedOutputText.equals(processedText);
    }

    @Test
    public void shouldHighlightKeywordsWithAppropriateColorsAndCase() {
        final KeywordHolder keywordHolder = new KeywordHolder();
        keywordHolder.addKeyword(new Keyword("as", "blue", "capital"));
        keywordHolder.addKeyword(new Keyword("if", "red", "lower"));
        keywordHolder.addKeyword(new Keyword("and", "red", "capital"));
        keywordHolder.addKeyword(new Keyword("then", "green", "lower"));
        keywordHolder.addKeyword(new Keyword("when", "blue", "lower"));

        final ColorDecorator colorDecorator = new ColorDecorator(keywordHolder);
        final CaseDecorator caseDecorator = new CaseDecorator(keywordHolder);
        final KeywordHighlighter highlighter = new KeywordHighlighter(keywordHolder, caseDecorator, colorDecorator);
        final String inputText = "If we write a program and compile it, then as we run the program, we will get output";
        final String expectedOutputText = "[red]if[red] we write a program [red]AND[red] compile it, [green]then[green] [blue]AS[blue] we run the program, we will get output";
        final String processedText = highlighter.processText(inputText);
        assert expectedOutputText.equals(processedText);
    }

    @Test
    public void shouldHighlightKeywordsWithAppropriateColorsCaseAndFontWeight() {
        final KeywordHolder keywordHolder = new KeywordHolder();
        keywordHolder.addKeyword(new Keyword("as", "blue", "capital", "normal"));
        keywordHolder.addKeyword(new Keyword("if", "red", "lower", "bold"));
        keywordHolder.addKeyword(new Keyword("and", "red", "capital", "bold"));
        keywordHolder.addKeyword(new Keyword("then", "green", "lower", "normal"));
        keywordHolder.addKeyword(new Keyword("when", "blue", "lower", "normal"));

        final ColorDecorator colorDecorator = new ColorDecorator(keywordHolder);
        final CaseDecorator caseDecorator = new CaseDecorator(keywordHolder);
        final FontWeightDecorator fontWeightDecorator = new FontWeightDecorator(keywordHolder);
        final KeywordHighlighter highlighter = new KeywordHighlighter(keywordHolder, caseDecorator, fontWeightDecorator, colorDecorator);
        final String inputText = "If we write a program and compile it, then as we run the program, we will get output";
        final String expectedOutputText = "[red][bold]if[bold][red] we write a program [red][bold]AND[bold][red] compile it, [green]then[green] [blue]as[blue] we run the program, we will get output";
        final String processedText = highlighter.processText(inputText);
        assert expectedOutputText.equals(processedText);
    }
}
