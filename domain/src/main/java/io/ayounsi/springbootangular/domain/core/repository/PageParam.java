package io.ayounsi.springbootangular.domain.core.repository;

public class PageParam {

    private final int page;
    private final int size;

    public PageParam(int page, int size) {
        this.page = page;
        this.size = size;
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }
}
