package io.ayounsi.springbootangular.persistence.jpa.core;

import io.ayounsi.springbootangular.domain.core.repository.PageParam;
import io.ayounsi.springbootangular.domain.core.repository.PageParamMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
public class PageSpringDataMapper implements PageParamMapper<PageRequest> {

    @Override
    public PageRequest apply(PageParam page) {
        return PageRequest.of(page.getPage(), page.getSize());
    }
}
