package br.com.sdvs.cdr.utils.datatable;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class DataTableOut<T> {

    private Integer draw;
    private Long recordsTotal;
    private Long recordsFiltered;
    private List<T> data;
    private String error;

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(Long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public Long getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(Long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public DataTableOut<T> getPageOut(Page<T> page, int draw){
        this.setData(page.getContent());
        this.setRecordsTotal(page.getTotalElements());
        this.setRecordsFiltered(page.getTotalElements());
        this.setDraw(draw);
        return this;
    }
}
