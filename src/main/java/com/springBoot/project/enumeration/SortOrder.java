package com.springBoot.project.enumeration;

public enum SortOrder {

    ASC("asc"),
    DESC("desc");

    String sortType;

    SortOrder(String sortType) {
        this.sortType = sortType;
    }

    @Override
    public String toString() {
        return this.sortType;
    }

}
