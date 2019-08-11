package io.ayounsi.springbootangular.persistence.jpa.core;

import io.ayounsi.springbootangular.domain.core.repository.SortParam;
import io.ayounsi.springbootangular.domain.core.repository.SortParamMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class SortMapperSpringDataImpl implements SortParamMapper<Sort> {

    @Override
    public Sort apply(SortParam sort) {
        return Sort.by(sort.getValue());
    }
}
