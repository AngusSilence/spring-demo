package com.kingland.neusoft.redis.config;

import com.kingland.neusoft.redis.controller.RedisController;
import com.kingland.neusoft.redis.controller.UserController;
import com.kingland.neusoft.redis.controller.impl.RedisControllerImpl;
import com.kingland.neusoft.redis.controller.impl.UserControllerImpl;
import com.kingland.neusoft.redis.repository.UserRepository;
import com.kingland.neusoft.redis.repository.impl.UserRepositoryImpl;
import com.kingland.neusoft.redis.service.RedisService;
import com.kingland.neusoft.redis.service.UserService;
import com.kingland.neusoft.redis.service.impl.RedisServiceImpl;
import com.kingland.neusoft.redis.service.impl.UserServiceImpl;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableCaching
public class RedisConfig {
    @Bean
    @Profile("memory")
    UserRepository userRepository() {
        return new UserRepositoryImpl();
    }

    @Bean
    UserService userService() {
        return new UserServiceImpl(userRepository());
    }

    @Bean
    UserController userController() {
        return new UserControllerImpl(userService());
    }

    @Bean
    RedisController redisController(RedisTemplate<String,String> redisTemplate){
        return new RedisControllerImpl(redisService(redisTemplate));
    }
    @Bean
    RedisService redisService(RedisTemplate<String,String> redisTemplate){
        return new RedisServiceImpl(redisTemplate);
    }



//    @Bean // redis连接
//    public RedisConnectionFactory redisConnectionFactory() {
//        JedisConnectionFactory cf = null;
//        if (clusterNodes != null && !clusterNodes.isEmpty()) {
//            cf = new JedisConnectionFactory(getClusterConfiguration());
//        } else {
//            RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
//            redisStandaloneConfiguration.setHostName(redisHost);
//            redisStandaloneConfiguration.setPort(redisPort);
//            redisStandaloneConfiguration.setPassword(RedisPassword.of(redisPasswd));
//            cf = new JedisConnectionFactory(redisStandaloneConfiguration);
//        }
//        cf.afterPropertiesSet();
//        return cf;
//    }

    @Bean // 实际使用的redisTemplate，可以直接注入到代码中，直接操作redis
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }


    @Bean
    CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory){
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory);

        // 默认配置，过期时间指定是30分钟
        RedisCacheConfiguration defaultCacheConfig = RedisCacheConfiguration.defaultCacheConfig();
        defaultCacheConfig.entryTtl(Duration.ofMinutes(30));

        // redisExpire1h cache配置，过期时间指定是1小时，缓存key的前缀指定成prefixaaa_（存到redis的key会自动添加这个前缀）
        RedisCacheConfiguration userCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig().
                entryTtl(Duration.ofHours(1)).prefixKeysWith("prefixaaa_");
        Map<String, RedisCacheConfiguration> redisCacheConfigurationMap = new HashMap<>();
        redisCacheConfigurationMap.put("redisExpire1h", userCacheConfiguration);

        RedisCacheManager cacheManager = new RedisCacheManager(redisCacheWriter,
                defaultCacheConfig, redisCacheConfigurationMap);
        return cacheManager;
    }
}
