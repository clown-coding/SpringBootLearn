# ***SpringBoot-Actuator***

**[SpringBootActuator官方文档](https://docs.spring.io/spring-boot/docs/2.1.2.RELEASE/reference/htmlsingle/#production-ready)**

## **配置文件**
```yml
management:
  endpoints:
    web:
      exposure:
        include: "*" 开启所有监控 springboot2.0开始只默认开启info,health两个节点
  endpoint:
    shutdown:
      enabled: true  允许远程关闭应用
```

# **节点-功能-url**


| 节点 |功能|访问url|
|---|---|---|
|shutdown|允许应用程序远程关闭(默认关闭 POST)| http://localhost:8080/actuator/shutdown|
| auditevents |公开当前应用程序的审核事件信息|http://localhost:8080/actuator/auditevents|
|beans|显示应用程序中所有Spring bean的完整列表|http://localhost:8080/actuator/beans|
|caches|显示可用的缓存(cacheManager)|http://localhost:8080/actuator/caches|
|conditions|显示在配置类和自动配置类上评估的条件以及它们匹配或不匹配的原因|http://localhost:8080/actuator/conditions|
|configprops|显示所有配置文件中的@ConfigurationProperties读取的配置信息|http://localhost:8080/actuator/configprops|
|env|Spring的IOC容器属性信息|http://localhost:8080/actuator/env|
|<font color=red>flyway</font>|<font color=red>显示已应用的任何Flyway数据库迁移</font>|<font color=red>http://localhost:8080/actuator/flyway</font>|
|health|显示应用健康信息|http://localhost:8080/actuator/health|
|httptrace|显示HTTP跟踪信息（默认情况下，最后100个HTTP 的 请求-响应）|http://localhost:8080/actuator/httptrace|
|info|显示任意应用信息|http://localhost:8080/actuator/info|
|<font color=red>integrationgraph</font>|<font color=red>显示Spring Integration图</font>|<font color=red>http://localhost:8080/actuator/integrationgraph</font>|
|loggers|显示和修改应用程序中日志配置信息|http://localhost:8080/actuator/loggers|
|<font color=red>liquibase</font>|<font color=red>显示已应用的任何Liquibase数据库迁移</font>|<font color=red>http://localhost:8080/actuator/liquibase</font>|
|metrics|显示当前应用程序的'度量'信息。|http://localhost:8080/actuator/metrics|
|mappings|显示所有的@RequestMapping路径的列表。|http://localhost:8080/actuator/mapping|
|scheduledtasks|显示应用程序中所有的定时任务。|http://localhost:8080/actuator/scheduledtasks|
|sessions|允许从Spring Session支持的会话存储中检索和删除用户会话。使用Spring Session对响应式Web应用程序的支持时不可用。|http://localhost:8080/actuator/session|
|threaddump|显示当前应用的所有线程|http://localhost:8080/actuator/threaddump|
||<font color=#FF00FF>如果您的应用程序是Web应用程序(Spring MVC，Spring WebFlux或Jersey)则可以使用以下附加端点</font>||
|heapdump|返回hprof转储的文件<font color=red>不要使用postman测试,使用浏览器直接访问,会下载一个文件</font>|http://localhost:8080/actuator/heapdump|
|<font color=red>jolokia</font>|<font color=red>通过HTTP公开JMX bean(当Jolokia在类路径上时，不适用于WebFlux)</font>|<font color=red>http://localhost:8080/actuator/jolokia|通过HTTP公开JMX bean(当Jolokia在类路径上时，不适用于WebFlux)</font>|
|logfile|返回日志文件的内容(如果已设置logging.file或logging.path属性)支持使用HTTP Range标头检索部分日志文件的内容。|http://localhost:8080/actuator/logfile|
|prometheus|以可以由Prometheus服务器抓取的格式公开指标|http://localhost:8080/actuator/prometheus|

# **修改端点信息**
* 关闭所有端点,只开启特定端点
```yml
management:
  endpoints:
    web:
      exposure:
        include: ["info","health","env"]
        # 只开启
```

* 修改访问路径
```yml
management:
# 修改访问端点端口号
  server:
    port: 9090
  endpoints:
    web:
      # 修改访问路径
      base-path: /management
      # 所有端点都可访问
      exposure:
        include: "*"

   http://localhost:9090/management/health
```

# **自定义端点健康状态信息**
* 编写一个健康指示器
* 实现 HealthIndicator 接口
* 指示器的名称必须是 XXXHealthIndicator
* 加入容器中
```java
@Component
public class MyAppHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        //自定义检查方法
        //return Health.up().build(); //健康
        return Health.down().withDetail("msg","服务异常").build(); //服务异常
    }
}
```