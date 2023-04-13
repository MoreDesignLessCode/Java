package com.cvshealth.mscoe.common.impl;

import java.util.Map;
import java.util.WeakHashMap;

import com.cvshealth.mscoe.common.interfaces.IContext;

public class DefaultRequestContext implements IContext {
    private final Map<Object, Map<String, Object>> data = new WeakHashMap<>();

    @Override
    public <T> void set(String key, T value) {
        Map<String, Object> currentContext = data.getOrDefault(this, new WeakHashMap<>());
        currentContext.put(key, value);
        data.put(this, currentContext);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T get(String key) {
        Map<String, Object> currentContext = data.get(this);
        return (T) (currentContext != null ? currentContext.get(key) : null);
    }

    public DefaultRequestContext() {}
}
