package main.java.keywordhighlighter.model;

public class Keyword {

    private String value;
    private String color;
    private String caseStyle;
    private String fontWeight;

    public Keyword(final String value) {
        this.value = value;
    }

    public Keyword(final String value, final String color) {
        this.value = value;
        this.color = color;
    }

    public Keyword(final String value, final String color, final String caseStyle) {
        this.value = value;
        this.color = color;
        this.caseStyle = caseStyle;
    }

    public Keyword(final String value, final String color, final String caseStyle, final String fontWeight) {
        this.value = value;
        this.color = color;
        this.caseStyle = caseStyle;
        this.fontWeight = fontWeight;
    }

    public String getValue() {
        return value;
    }

    public String getColor() {
        return color;
    }

    public String getCaseStyle() {
        return caseStyle;
    }

    public String getFontWeight() {
        return fontWeight;
    }
}
