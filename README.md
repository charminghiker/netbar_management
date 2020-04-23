## 齐鲁工业大学毕业设计——基于WEB的网吧计费系统
**autor：charminghiker**  
**email：charminghiker@163.com**

#### 项目说明
+ 开发工具：IDEA
+ 数据库：Mysql
+ 技术栈：前端H5、Thymeleaf + 后端Springboot + Mybatis ***（前后端不分离***

#### 使用说明
+ 数据库备份：mysql根目录下netbar_data.sql
+ 数据库配置文件：src/main/resouces/application.yml

#### 入口方法
+ >***src/main/java/com/qlu/netbar_1/Netbar1Application.java***
#### 路径
+ controller
  >***src/main/java/com/qlu/netbar_1/controller***
+ 数据库查询接口
  >***src/main/java/com/qlu/netbar_1/mapper***
+ model类
  >***src/main/java/com/qlu/netbar_1/pojo***
+ 数据库接口实现文件
  >***src/main/resources/mapper***
+ 静态文件（js、css、图片
  >***src/main/resources/static***
+ 使用Thymeleaf的HTML文件
  >***src/main/resources/templates***

#### 简介
本项目大致分为几个模块：账户管理、机器管理、营业操作……

#### 展望
因校内才疏学浅，页面大部分是基本HTML，项目技术上不算复杂。作为一个经常性用的管理系统，放在Web上确实不妥。以现在的经验可以做一些改进：页面改由react或vue来做更高效，项目可以封装进electron来实现桌面端的目的。