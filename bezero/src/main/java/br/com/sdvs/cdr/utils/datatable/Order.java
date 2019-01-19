package br.com.sdvs.cdr.utils.datatable;

public class Order {

    private Integer column;
    private String dir;

    public Order() {
    }

    public Order(Integer column, String dir) {
        super();
        this.column = column;
        this.dir = dir;
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }
}
