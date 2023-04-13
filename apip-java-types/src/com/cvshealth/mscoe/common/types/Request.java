package com.cvshealth.mscoe.common.types;

import java.util.Map;

public interface Request {
    // empty interface
}

interface PathParams {
    String getId();
    void setId(String id);
}

class QueryParameters {
    private Map<String, Object> parameters;

    public QueryParameters() {}

    public QueryParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }
}

