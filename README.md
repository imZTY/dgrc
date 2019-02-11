# DGRC

## 项目背景
2018年暑假，刚学完医学统计学的我，参与了老师的一个有关药物重定向的研究课题———“基于Fisher精确检验，由基因相关性推断药物与疾病的相关性”，为了更好地展示研究成果，故特做此网站。 

## 项目结构
```
.
├─main
│  ├─java
│  │  └─sci
│  │      └─again
│  │          └─dgrc
│  │              ├─controller 控制类
│  │              ├─domain Neo4j数据实体类
│  │              ├─entity Mysql表数据实体类
│  │              ├─repositories 基于Jpa的DAO类
│  │              ├─services 服务类
│  │              ├─util 工具类
│  │              └─DTO 数据传输类
│  └─resources 各配置
│      ├─static 各静态资源
│      │  ├─css
│      │  ├─js
│      │  └─pictures
│      └─templates 各页面
└─test
```

## 涉及技术：
1. 使用 Spring-JPA 实现 DAO 业务；
2. 混合使用双数据库：关系性数据库(MySQL) + 非关系型数据库(Neo4j)
3. 前端使用：传统HTML/JS/CSS + vis.js 实现关系图谱可视化；
4. 使用 Nginx 反向代理实现前后端分离发布；

## 亮点
1. 涉及了Neo4j数据库的Java操作

## 不足
1. 界面设计不美观、布局混乱

## 截图展示

