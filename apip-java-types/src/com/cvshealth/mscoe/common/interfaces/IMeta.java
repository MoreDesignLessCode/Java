package com.cvshealth.mscoe.common.interfaces;

import java.util.List;
import java.util.Map;

public interface IMeta {
    Paging getPaging();
    void setPaging(Paging paging);
    Sorting getSorting();
    void setSorting(Sorting sorting);
    Fields getFields();
    void setFields(Fields fields);
    Filtering getFilters();
    void setFilters(Filtering filters);
}

 interface Paging {
    int getLimit();
    int getOffset();
    int getTotal();
    void setLimit(int limit);
    void setOffset(int offset);
    void setTotal(int total);
}

 class Sorting {
    private List<String> asc;
    private List<String> desc;

    public List<String> getAsc() {
        return asc;
    }

    public void setAsc(List<String> asc) {
        this.asc = asc;
    }

    public List<String> getDesc() {
        return desc;
    }

    public void setDesc(List<String> desc) {
        this.desc = desc;
    }
}

 class Fields {
    private List<String> omitted;
    private List<String> requested;

    public List<String> getOmitted() {
        return omitted;
    }

    public void setOmitted(List<String> omitted) {
        this.omitted = omitted;
    }

    public List<String> getRequested() {
        return requested;
    }

    public void setRequested(List<String> requested) {
        this.requested = requested;
    }
}

 class Filtering {
    private Map<String, FilterValue> filters;

    public Map<String, FilterValue> getFilters() {
        return filters;
    }

    public void setFilters(Map<String, FilterValue> filters) {
        this.filters = filters;
    }
}

 class FilterValue {
    private String operator;
    private String value;

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}


