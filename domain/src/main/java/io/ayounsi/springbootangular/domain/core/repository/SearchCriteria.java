package io.ayounsi.springbootangular.domain.core.repository;

/**
 * @author ONE WAY
 */
public class SearchCriteria {

    // =============================================
    //               Attributes
    // =============================================
    private final String key;
    private final SearchOperation operation;
    private final Object value;

    // =============================================
    //               Constructors
    // =============================================
    public SearchCriteria(String key, SearchOperation operation, Object value) {
        this.key = key;
        this.operation = operation;
        this.value = value;
    }

    // =============================================
    //               Getters
    // =============================================
    public String getKey() {
        return key;
    }

    public SearchOperation getOperation() {
        return operation;
    }

    public Object getValue() {
        return value;
    }

}
