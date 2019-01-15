# springboot-server
##A server demo with jwt/shiro/mybatis-plus etc.

# 一、项目背景
###Springboot作为轻量化框架已经受到广大开发者的喜爱,且适用于微服务敏捷开发及前后端分离。
###本工程以Springboot为主体,结合shiro、jwt、mybatis-plus等框架/模块,形成一个基于接口交互的后端server demo。
MyBatis-Plus（简称 MP）是一个 MyBatis 的增强工具，在 MyBatis 的基础上只做增强不做改变，为简化开发、提高效率而生。具有无侵入、损耗小、支持逐渐自动生成等特性。 

JSON Web Token (JWT)是一个开放标准(RFC 7519)，它定义了一种紧凑的、自包含的方式，用于作为JSON对象在各方之间安全地传输信息。该信息可以被验证和信任，因为它是数字签名的。

Apache Shiro 是 Java 的一个安全框架。功能强大，使用简单的Java安全框架，它为开发人员提供一个直观而全面的认证，授权，加密及会话管理的解决方案。

# 二、项目结构
          当前版本V1.0.2
          
          |-- src
              |-- test/java/com/noahw/platform
              |-- main
                  |-- java/com/noaw/platform
                      |-- base 基础类目录
                      |-- constants 常量目录
                      |-- controller 控制器目录,包含异常处理
                      |-- exception 异常类目录
                      |-- i18n 国际化配置
                      |-- persistence 持久层
                      |-- result 返回消息封装
                      |-- security 安全框架相关
                      |-- service 业务服务目录
                      |-- util 工具类目录
                      |-- PlatformApplication.java 启动入口
                  |-- resources 资源文件目录
                      |-- config 配置资源
                      |-- i18n 国际化资源
                      |-- application.properties
                      
# 三、项目特性
1.工程启动入口：PlatformApplication.main(...) 

2.工程使用AOP切点统一记录、打印接口调用等信息,具体见base/ParamLogger
 
3.统一定义ExceptionController进行异常处理 

4.交互使用JWT校验,用户登录(login)时后端返回token参数,在调用带有@RequiresAuthentication的接口函数时,前端需带有Authorization的消息头,Authorization的value为登录时返回的token 

5.使用统一的i18n国际化配置,当前有en_US、zh_CN两种语言配置,默认中文

6.当需要参数校验时,在相应controller方法需校验的参数中添加注解@Validated,相应dto变量也需添加注解

# 四、TODO
当前项目存在的不足： 

1.~~用户密码未做加密,目前正在考虑方案选择~~ 已使用md5加密

2.JWT token校验错误当前返回HTTP STATUS CODE为401,待完善

3.异常处理正在考虑更为合适的方案

4.application.properties当前未做开发环境和生成环境的剥离

5.当前未做模块化,后续可改进

