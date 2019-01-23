# ***SpringBoot-Elasticsearch***

# ***官方文档***

* **[Elasticsearch官方文档](https://www.elastic.co/guide/cn/index.html)**
* **[Spring-Data-Elasticsearch官方文档](https://docs.spring.io/spring-data/elasticsearch/docs/3.1.4.RELEASE/reference/html/#elasticsearch.repositories)**

## **logstash与mysql数据同步**

* 现在mysql驱动
* 创建mysql.conf文件
* 将驱动与文件放入logstash根目录下
* 修改mysql.conf文件信息

* 输入命令启动logstash
```java
logstash -f G:\springboot_tools\elasticsearch\elasticsearch\elasticsearch5.6.8\logstash\logstash-5.6.8\mysqllogstash\mysql.conf
```

## **Elasticsearch**

* SpringBoot默认支持两种技术和ES交互
   * Jest
      * 默认不生效
      * 需导入 import io.searchbox.client.JestClient;
   * Elasticsearch

**<font color=red size = 6>ElasticSearch访问9300端口问题</font>**

* 本工程使用的Spring-data-elasticsearch版本是3.1.3
* 本工程使用的ES是6.4.3
* 去spring官网查找对应的版本
   * [Spring-data-elasticsearch与elasticsearch版本对照表](https://github.com/spring-projects/spring-data-elasticsearch)


   | Spring-data-elasticsearch版本 |elasticsearch版本|
   |---|---|
   | 3.2.x|6.5.0|
   | 3.1.x |6.2.2|
   | 3.0.x |5.5.0|
   | 2.1.x  |2.4.0|
   | 2.0.x |2.2.0|
   | 1.3.x |1.5.2|

<font color=red size=6>当出现应用无法启动的情况</font>
* 安装ES的版本号与ES的jar包版本号对应
* 本工程的ES的jar包的版本号与安装的ES对应

* 你安装的ES版本与工程中的elasticsearch的jar包版本一致,再去查看elasticsearch的jar包版本与Spring-data-elasticsearch版本是否对应

* 出现以下错误查看是不是版本的问题
```java
2019-01-23 22:19:48.898 ERROR 2968 --- [           main] .d.e.r.s.AbstractElasticsearchRepository : failed to load elasticsearch nodes : org.elasticsearch.index.mapper.MapperParsingException: No type specified for field [title]
```

