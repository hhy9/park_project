package com.hhy.web;

import org.springframework.stereotype.Component;

@Component
public class Pager {
    private String search;

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
