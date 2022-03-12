# 1 官方下载解压，bin运行
# 2 使用
> 使用postman发送restful风格的请求。
## 2.1 创建索引
put http://localhost:9200/shopping
## 2.2 查看索引
查看单个：get http://localhost:9200/shopping
查看全部索引： get http://localhost:9200/_cat/indices?v
## 2.3 删除索引 delete方式即可
