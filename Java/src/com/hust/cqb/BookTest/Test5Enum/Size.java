package com.hust.cqb.BookTest.Test5Enum;

enum Size {
    SMALL("S"),
    MEDIUM("M"),
    LARGE("L"),
    EXTRA_LARGE("XL");

    private String abbreviation;
    private Size(String abbreviation) { this.abbreviation = abbreviation; }

    public String getAbbreviation() {
        return abbreviation;
    }
}
