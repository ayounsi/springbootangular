package io.ayounsi.springbootangular.domain.commons.model;

import java.io.Serializable;

public interface ValueObject extends Serializable {

    boolean sameValueAs(Object other);
}
