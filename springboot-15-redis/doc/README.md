# ***SpringBoot-RedisCache***

**[Redis中文网](http://www.redis.cn/)**

## **1.引入依赖**
```pom
<dependencies>
    <!-- Data-Redis -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-redis</artifactId>
    </dependency>

    <!-- mybatis依赖-->
    <dependency>
        <groupId>org.mybatis.spring.boot</groupId>
        <artifactId>mybatis-spring-boot-starter</artifactId>
        <version>1.3.1</version>
    </dependency>

    <!-- mysql驱动 -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <scope>runtime</scope>
    </dependency>
</dependencies>
```
## **2.编写配置文件*
```yml
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/springboot-redis?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8
    username: root
    password: '123456'
    schema:
    - classpath:sql/springboot-redis.sql
    initialization-mode: always
#redis配置
  redis:
    host: 192.168.25.145
    port: 6379
#mybatis配置
mybatis:
  configuration:
    map-underscore-to-camel-case: true
  type-aliases-package: com.clown.redis.model
  mapper-locations: classpath:mybatis/mapper/*.xml
#logging配置
logging:
  level:
    com.clown.redis.mapper: debug
```

# **Redis数据操作**
 * Redis常见5大数据类型
    * String(字符串). list(列表). Set(集合). Hash(散列 ). ZSet(有序集合)
 * 5大数据操作
    *  操作字符串:  stringRedisTemplate.opsForValue()
    *  操作Hash:   stringRedisTemplate.opsForHash()
    *  操作list:   stringRedisTemplate.opsForList()
    *  操作Set:    stringRedisTemplate.opsForSet()
    *  操作ZSet:   stringRedisTemplate.opsForZSet()