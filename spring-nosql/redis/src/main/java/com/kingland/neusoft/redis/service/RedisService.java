package com.kingland.neusoft.redis.service;

import com.kingland.neusoft.redis.model.RedisModel;

public interface RedisService {

    String getValueByKey(String key);


    void setValueByKey(RedisModel redisModel);
}
