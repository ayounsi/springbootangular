package io.ayounsi.springbootangular.domain.core.repository;

public class SortParam {

    private final String value;

    private SortParam(String value) {
        this.value = value;
    }

    public static SortParam of(String value) {
        return new SortParam(value);
    }

    public String value() {
        return value;
    }

    public String getValue() {
        return value;
    }
}
