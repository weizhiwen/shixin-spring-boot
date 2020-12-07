# shixin-spring-boot


定制化的SpringBoot框架，更快的业务开发。

customized springboot for faster business development.

---

## 框架模块

```shell
shixin-spring-boot  
├── shixin-spring-boot-dependencies  
├── shixin-spring-boot-parent  
├── shixin-spring-boot-commons  
├── shixin-spring-boot-dal  
└── shixin-spring-boot-framework
```

框架的模块按照 SpringBoot 官方模块的组织方式，shixin-spring-boot-dependencies 类似与 SpringBoot 的 spring-boot-dependencies，
用来统一维护整个项目的依赖关系和版本；shixin-spring-boot-parent 类似与 SpringBoot 的 spring-boot-parent，充当其余子模块的父模块；
shixin-spring-boot-commons 是整个框架的通用模块，包含通用的 POJO类和工具类；shixin-spring-boot-dal 是整个框架的数据层模块，包含使用 JPA
进行数据访问的通用方法，可以与 Mybatis 共用来达到复杂场景（蛇皮需求）的查询需要；shixin-spring-boot-framework 是整个框架的核心，包含了在使用
在写API接口的常用类和通用处理方法，让你集中精力去写业务代码，而不需要关心接口数据格式、时间转换、异常处理等配置。

shixin-spring-boot-example 是单独的示例模块，展示了如何使用该框架进行业务开发，包含登录、一个数据实体的增删改查。


