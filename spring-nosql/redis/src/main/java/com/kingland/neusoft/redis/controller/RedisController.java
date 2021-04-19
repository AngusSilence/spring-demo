package com.kingland.neusoft.redis.controller;

import com.kingland.neusoft.redis.model.RedisModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
public interface RedisController {
    @GetMapping("/{key}")
    String getValueByKey(@PathVariable("key") String key);

    @PostMapping
    String setValueByKey(@RequestBody  RedisModel redisModel);
}
