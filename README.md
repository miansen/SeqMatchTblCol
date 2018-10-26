##测试，1.0分支做了修改

## 使用说明

这是一个通过序列名查找对应的表名和字段的程序，因为比较简单，所以没有用到Maven和框架，程序所需要的架包已经包含在了jar目录里了。

如果你的序列命名格式为：表名_字段名(例如:USER_USER_ID)或者XXX_表名_字段名(例如:SEQ_USER_USER_ID)，就可以通过本程序找到对应的表名和字段

## 截图展示

![img](https://i.loli.net/2018/10/26/5bd2e1ef143b6.jpg)

## 快速开始

### 服务器部署

1.下载压缩包

```
wget https://github.com/miansen/SeqMatchTblCol/releases/download/SeqMatchTblCol-v1.0/SeqMatchTblCol.tar.gz
```

2.解压

```
tar -zxvf SeqMatchTblCol.tar.gz
```

3.进入SeqMatchTblCol目录

```
cd SeqMatchTblCol
```

4.修改配置文件`db.properties`，数据库连接信息换成你自己的

5.在数据库中建`SEQ_MATCH_TBL_COL`表，建表脚本在`SEQ_MATCH_TBL_COL.sql`文件里

6.将用户名和序列名插入到`SEQ_MATCH_TBL_COL`表里

7.执行程序

```
sh start.sh
```

8.停止程序

```
sh shutdown.sh
```

### 本地运行

1.克隆项目



2.将项目导入开发工具中（如Eclipse）

3.修改配置文件`db.properties`，数据库连接信息换成你自己的

4.在数据库中建`SEQ_MATCH_TBL_COL`表，建表脚本在`SEQ_MATCH_TBL_COL.sql`文件里

5.将用户名和序列名插入到`SEQ_MATCH_TBL_COL`表里

6.运行`SeqMatchTblColApplication`类

## 反馈

[issues](https://github.com/miansen/SeqMatchTblCol/issues)

## 贡献

欢迎大家提 issues，谢谢！

## License

MIT
