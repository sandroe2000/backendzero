package br.com.sdvs.cdr.utils.datatable;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class DataTableIn {

    private Integer draw;
    private Integer start;
    private Integer length;
    private Search search;
    private String extra;
    private List<Order> order;
    private List<Column> columns;

    public DataTableIn() {
        this.search = new Search();
        this.order = new ArrayList<Order>();
        this.columns = new ArrayList<Column>();
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Search getSearch() {
        return search;
    }

    public void setSearch(Search search) {
        this.search = search;
    }

    public String getExtra() { return extra; }

    public void setExtra(String extra) { this.extra = extra; }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    public Pageable getPageableIn() {
        List<Sort.Order> orders = new ArrayList<Sort.Order>();
        for (Order order : this.getOrder()) {
            Column column = this.getColumns().get(order.getColumn());
            if (column.getOrderable()) {
                String sortColumn = column.getData();
                Sort.Direction sortDirection = Sort.Direction.fromString(order.getDir());
                orders.add(new Sort.Order(sortDirection, sortColumn));
            }
        }
        Sort sort = orders.isEmpty() ? null : new Sort(orders);

        if (this.getLength() == -1) {
            this.setStart(0);
            this.setLength(Integer.MAX_VALUE);
        }
        return new PageRequest(this.getStart() / this.getLength(), this.getLength(), sort);
    }

    public String getSerchValue(){
        return this.getSearchLike(search.getValue());
    }

    private String getSearchLike(String search) {
        return search == null || search.length() < 1 ? "%" : search + "%";
    }
}