# ***SpringBoot自定义Starter***

## **1.创建custom-springboot-starter模块**
* POM文件中引入custom-springboot-starter-autoconfigurer的jar包
```pom
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.clown</groupId>
    <artifactId>custom-springboot-starter</artifactId>
    <version>1.0-SNAPSHOT</version>
    <!-- 启动器 -->
    <dependencies>
        <!-- 引入自动配置模块-->
        <dependency>
            <groupId>com.clown</groupId>
            <artifactId>custom-springboot-starter-autoconfiguration</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
    </dependencies>
</project>
```
*
## **2.创建custom-springboot-starter-autoconfigurer模块**
* POM文件中引入spring-boot-starter依赖
```pom
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.clown</groupId>
    <artifactId>custom-springboot-starter-autoconfiguration</artifactId>
    <version>1.0-SNAPSHOT</version>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.1.1.RELEASE</version>
    </parent>
    <!--使用的JDK版本和编码集-->
    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
        <java.version>1.8</java.version>
    </properties>
    <!-- 引入springboot-starter: 所有starter的基本配置-->
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
        </dependency>
    </dependencies>
</project>
```

* 创建服务类
   * HelloService
     ```java
     package com.clown.starter;
     public class HelloService {
         HelloProperties helloProperties;
         public HelloProperties getHelloProperties() {
             return helloProperties;
         }

         public void setHelloProperties(HelloProperties helloProperties) {
             this.helloProperties = helloProperties;
         }

         public String sayHelloClown(String name ){
             return helloProperties.getPrefix()+" "+name + " "+helloProperties.getSuffix();
         }
     }

     ```
   * HelloProperties
     ```java
     package com.clown.starter;
     import org.springframework.boot.context.properties.ConfigurationProperties;
     @ConfigurationProperties(prefix = "clown.hello")
     public class HelloProperties {

         private String prefix;

         private String suffix;

         public String getPrefix() {
             return prefix;
         }
         public void setPrefix(String prefix) {
             this.prefix = prefix;
         }
         public String getSuffix() {
             return suffix;
         }
         public void setSuffix(String suffix) {
             this.suffix = suffix;
         }
     }
     ```
   * HelloServiceAutoConfiguration
     ```java
     package com.clown.starter;
     import org.springframework.beans.factory.annotation.Autowired;
     import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
     import org.springframework.boot.context.properties.EnableConfigurationProperties;
     import org.springframework.context.annotation.Bean;
     import org.springframework.context.annotation.Configuration;

     @Configuration
     @ConditionalOnWebApplication //web应用才生效
     @EnableConfigurationProperties(HelloProperties.class)
     public class HelloServiceAutoConfiguration {
         @Autowired
         HelloProperties helloProperties;
         @Bean
         public HelloService helloService(){
             HelloService helloService = new HelloService();
             helloService.setHelloProperties(helloProperties);
             return helloService;
         }
     }

     ```
* 在resource下创建META-INF文件夹,并在此文件夹下创建文件spring.factories
```properties
# Auto Configure
org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
com.clown.starter.HelloServiceAutoConfiguration
```

## **3.将以上两个模块安装到maven仓库,供其他模块调用**
* 将custom-springboot-starter-autoconfigurer模块install到maven仓库
* 将custom-springboot-starter模块install到maven仓库

## **4.引用自定义的Starter**
* 创建应用springboot-12-custom-starter
* POM文件中引用自定义的starter
```pom
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>SpringBootLearn</artifactId>
        <groupId>com.clown</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>
    <artifactId>springboot-13-custom-starter</artifactId>

    <!-- 引入自定义starter-->
    <dependencies>
        <dependency>
            <groupId>com.clown</groupId>
            <artifactId>custom-springboot-starter</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
    </dependencies>
</project>
```
* 配置文件中添加配置信息
```yml
clown:
  hello:
    prefix: clown
    suffix: clown is laughing at you...
```

* 编写controller
```java
@RestController
public class ListenController {

    @Autowired
    HelloService helloService;

    @GetMapping("/listen")
    public String  hello(){
        return helloService.sayHelloClown("say");
    }
}
```

* 浏览器访问http://localhost:8080/listen

