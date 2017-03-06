package com.unionlive.util;

import java.util.LinkedHashMap;

/**
 * 重新 put方法，实现Map内容追加
 */
public class AppendMap extends LinkedHashMap {


    @Override
    public AppendMap put(Object key, Object value) {
        super.put(key, value);
        return this;
    }
}
