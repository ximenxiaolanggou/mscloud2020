## DependencyManagement

![image-20201012211107596](./images/dependencyManagement.png)

![](./images/2.png)

## 热部署

### 添加依赖

```xml
<!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-devtools -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
   <scope>runtime</scope>
    <optional>true</optional>
</dependency>
```

### 添加插件

```xml
	下一段配置黏贴到父工程当中的pom里
 
<build>
  <plugins>
    <plugin>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-maven-plugin</artifactId>
      <configuration>
        <fork>true</fork>
        <addResources>true</addResources>
      </configuration>
    </plugin>
  </plugins>
</build>
```

### 开启自动编译

![](./images/enableauocompail.jpg)

### 更新值

![](C:\Users\西门小狼狗\AppData\Roaming\Typora\typora-user-images\image-20201012212031499.png)

### 重启Idea

## Eureka 1.0和2.0对比
![](./images/3.jpg)
