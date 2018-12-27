package br.com.sdvs.cdr.utils.datatable;

public class Search {

    private Boolean regex;
    private String value;

    public Search() {
    }

    public Search(Boolean regex, String value) {
        super();
        this.regex = regex;
        this.value = value;
    }

    public Boolean getRegex() {
        return regex;
    }

    public void setRegex(Boolean regex) {
        this.regex = regex;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
