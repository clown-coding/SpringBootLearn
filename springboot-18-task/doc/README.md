# ***SpringBoot-Task***

## **异步任务**
* 启动类添加注解@EnableAsync            //开启异步任务
* 方法上添加注解
```java
@Async
@Override
public String add(User user) {
    try {
        Thread.sleep(3000);
        userMapper.save(user);
        return "添加成功";
    } catch (InterruptedException e) {
        return "添加失败";
    }
}
```

## **定时任务**
* 启动类添加注解 @EnableScheduling       //开启定时任务
* 方法添加注解@Scheduled(cron = "* * * * * *")

* cron()参数
   * second(秒), minute(分), hour(时), day of week(一周的哪一天), day of month(一个月的哪一天),month(月),
   * "0 * * * * MON-FRI"[从周一到周五每一分钟都启动一次]
* 例
   * @Scheduled(cron = "0 * * * * SUN")                      每天0分0秒执行一次
   * @Scheduled(cron = "0,1,2,3,4,* * * * SUN")              每天 每时 没分 秒针是 0s,1s,2s,3s,4s的时候执行一次

   * @Scheduled(cron = "0-4,* * * * SUN")                    每天 每时 没分 每隔4s执行一次
   * @Scheduled(cron = "0/4 * * * * SUN")

   * @Scheduled(cron = "0 0/5 14,18 * * ?")                  每个月的每天14点整,18点整 每隔5分钟执行一次
   * @Scheduled(cron = "0 15 10 ? * 1-6")                    每个月的周1至周6 10:15执行一次
   * @Scheduled(cron = "0 0 2 ? * 6L")                       每个月的最后一个周六凌晨2点执行一次
   * @Scheduled(cron = "0 0 2 LW * ?")                       每个月的最后一个一个工作日凌晨2点执行一次
   * @Scheduled(cron = "0 0 2-4 ? * 1#1")                    每个月的第一个周一的凌晨2点到4点之间,每个整点都执行一次

   * @Scheduled(cron = "0 59 20 * * *")                      每天6点发送生日祝福消息 GMT+8
* cron表达式写法


| 字段 |允许值|允许的特殊字符|
|---|---|---|
| 秒 |0-59|, - * /|
| 分 |0-59|, - * /|
| 小时 |0-23|, - * /|
| 日期 |1-31|, - * ? / L W C|
| 月份 |1-12或JAN-DEC|, - * /|
| 星期 |1-7或SUN-SAT|, - * ? / L C #|
| 年（可选） |空 1970-2099| , - * /|
|  |||



| 特殊字符 |代表含义|
|---|---|
| , |枚举|
| - |区间|
| * |任意|
| / |步长|
| ? |日/星期冲突匹配|
| L |最后|
| W |工作日|
| C |和calendar联系后计算过的值|
| # |星期，4#2，第2个星期三|



