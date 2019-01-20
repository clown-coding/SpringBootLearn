# ***SpringBoot与DataJpa***

### **1.引入依赖**
```pom
<dependencies>
    <!-- DataJPA-->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>

    <!-- mysql驱动 -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
    </dependency>

    <!-- druid 连接池-->
    <dependency>
        <groupId>com.alibaba</groupId>
        <artifactId>druid-spring-boot-starter</artifactId>
        <version>1.1.10</version>
    </dependency>
</dependencies>
```

### **2.配置信息**
```yml
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/springboot-jpa?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8
    username: root
    password: '123456'
    schema:
    - classpath:sql/department.sql
    - classpath:sql/employee.sql
    initialization-mode: never
    type: com.alibaba.druid.pool.DruidDataSource #切换数据源为druid
    #数据源其他配置
    initialSize: 5                             #数据库连接池初始化连接个数
    minIdle: 5
    maxActive: 20
    maxWait: 60000
    timeBetweenEvictionRunsMillis: 60000
    minEvictableIdleTimeMillis: 300000
    validationQuery: SELECT 1 FROM DUAL
    testWhileIdle: true
    testOnBorrow: false
    testOnReturn: false
    poolPreparedStatements: true
    #配置监控统计拦截的filters，去掉后监控界面sql无法统计，'wall'用于防火墙
    filters:
    - stat
    - wall
    - logback
    maxPoolPreparedStatementPerConnectionSize: 20
    useGlobalDataSourceStat: true
    connectionProperties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=500
#JPA配置
  jpa:
    database: mysql
    show-sql: true
    generate-ddl: true
```

**[SpringDataJpa官方文档](https://docs.spring.io/spring-data/jpa/docs/2.0.13.RELEASE/reference/html/)**