package com.jin.kafka.serialization;

import com.alibaba.fastjson.JSON;

/**
 * @author wu.jinqing
 * @date 2017年09月11日
 */
public class FastJsonSerializer<T> extends JsonSerializer<T> {
    @Override
    String toJsonString(T obj) {
        String data = JSON.toJSONString(obj);
        return data;
    }
}
