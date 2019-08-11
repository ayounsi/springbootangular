package io.ayounsi.springbootangular.domain.core.repository;

import java.util.function.Function;

public interface PageParamMapper<T> extends Function<PageParam, T> {
}
