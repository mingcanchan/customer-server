package com.ming.commons;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenmingcan on 2017/2/13.
 */
public abstract class BaseServer {

    private final Map<String, String> options = new HashMap<String, String>();

    public void setOption(String key, String value) {
        this.options.put(key, value);
    }

    public Map<String, String> getOptions() {
        return this.options;
    }

    /**
     * reload params
     *
     *      服务参数
     */
    public abstract void reinitialize();

    /**
     *      停止
     */
    public abstract void stop();
}