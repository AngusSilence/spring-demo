package com.kingland.neusoft.redis.controller.impl;

import com.kingland.neusoft.redis.controller.RedisController;
import com.kingland.neusoft.redis.model.RedisModel;
import com.kingland.neusoft.redis.service.RedisService;

public class RedisControllerImpl implements RedisController {
    private RedisService redisService;

    public RedisControllerImpl(RedisService redisService) {
        this.redisService = redisService;
    }

    @Override
    public String getValueByKey(String key) {
        return redisService.getValueByKey(key);
    }

    @Override
    public String setValueByKey(RedisModel redisModel) {
        redisService.setValueByKey(redisModel);
        return redisModel.getValue();
    }
}
