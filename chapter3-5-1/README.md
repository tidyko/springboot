# 目录
    shiro-example-chapter01  增加  记住我
    shiro-example-chapter02  增加 encache 缓存
    shiro-example-chapter03  增加 session 会话管理
    



#  shiro  添加依赖 

        <!-- shiro权限控制框架 -->
        <dependency>
            <groupId>org.apache.shiro</groupId>
            <artifactId>shiro-spring</artifactId>
            <version>1.4.0</version>
        </dependency>
        
        <!-- 增加 thymeleaf 和 shiro 标签依赖 -->        
        <dependency>
            <groupId>com.github.theborakompanioni</groupId>
            <artifactId>thymeleaf-extras-shiro</artifactId>
            <version>2.0.0</version>
        </dependency>
        
        html 页面增加：  <html lang="zh_CN" xmlns:th="http://www.thymeleaf.org" xmlns:shiro="http://www.pollix.at/thymeleaf/shiro">
        
    1.Subject  用户主题 把操作交给 SecurityManager
    2.SecurityManager  安全管理器  关联Realm 
    3.Realm  Shiro 连接数据的桥梁
    
    
    创建 自定义 realm  MyShiroRealm
    创建 SecurityManager 并与自定义的 MyShiroRealm 进行关联
    创建 ShiroFilterFactoryBean  并与 SecurityManager 进行关联
    
    
#第三方

       http://localhost:8351/login
       http://localhost:8351/hello/success
       
   
 # shiro 报错
    java.lang.IllegalArgumentException: Odd number of characters.
    问题出在 doGetAuthenticationInfo 方法中的
    return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), salt, getName());