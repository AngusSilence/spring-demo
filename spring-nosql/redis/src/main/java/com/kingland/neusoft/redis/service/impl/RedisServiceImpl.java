package com.kingland.neusoft.redis.service.impl;

import com.kingland.neusoft.redis.model.RedisModel;
import com.kingland.neusoft.redis.service.RedisService;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisServiceImpl implements RedisService {
    public RedisServiceImpl(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    RedisTemplate<String,String> redisTemplate;
    @Override
    public String getValueByKey(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public void setValueByKey(RedisModel redisModel) {
         redisTemplate.opsForValue().set(redisModel.getKey(),redisModel.getValue());
    }
}
