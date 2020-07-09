# Demos For News

![codecov]

Code for myself

* <a href="#1">Architectural</a>
* <a href="#2">App User flow path</a>
* <a href="#3">Admin User flow path</a>
* <a href="#4">Mysql to ElasticSearch</a>
* <a href="#5">Modules</a>
* <a href="#6">Service plan</a>
* <a href="#7">Database</a>
* <a href="#8">How To Run</a>
* <a href="#9">Code coverage report</a>

## environment：

| Tools | version & describe               |
| ----- | -------------------------------- |
| JDK   | 1.8                              |
| IDE   | eclipse/sts/idea		   |
| Maven | 3.x  				   |

## Technology stack

* Spring boot 2.1.6.Release
* Spring clound Finchley.SR3
* Alibaba Druid 1.1.10
* Mybatis plus 3.1.0
* Mybatis 3.5.1
* Redis 4.0
* Mysql 5.7
* ElasticSearch 
* Alibaba Canal 1.1.4

## <a name="1">Architectural</a>

![platform](./architecture.svg)

## <a name="2">App User flow </a>

![flow](./appflow.svg)

* Sequence diagram

![platform](./appseq.svg)

## <a name="3">Admin User flow </a>

![flow](./adminflow.svg)

* Sequence diagram

![platform](./adminseq.svg)

## <a name="4">Mysql to ElasticSearch(时间有限没实现)</a>

* Sequence diagram

![platform](./canal.svg)

## <a name="5">Modules</a>
  
- news-parent
	- news-service-registry (*Service Register And Discovery Center*)
	- news-config-server (*Configuration Center*)
	- news-gateway (*API Gateway*)
	- news-auth-server (*Authorization server*)
	- news-web-layer (*Interface for APP & admin*)
		- news-web-app (*Interface for app*)
		- news-web-admin (*Interface for admin*)
	- news-ms-layer (*Micro Service*)
		- news-ms-support (*Support Service*)
		- news-ms-content (*Content Service*)
	- news-user-service (*user module*)
		- news-user-service-api (*entity & interface*)
		- news-user-service-local (*business*)
		- news-user-service-web (*controller*)
		- news-user-service-starter (*all module*)
	- news-content-service (*content module*)
		- news-content-service-api
		- news-content-service-local
		- news-content-service-web
		- news-content-service-starter

## <a name="6">Service plan</a>

| module name                               | port  | describe                             | percent    | 
| ------------------------------------------| ------| ------------------------------------ | ---------- |
| news-service-registry                	    | 8761  | Service Register And Discovery Center|100%    |
| news-config-server               	    | 8672  | config center                        |100%    |
| news-gateway               		    | 8673  | api gateway                	   |100%    |
| news-auth-server        		    | 8674  | Authorization server                 |100%    |
| news-resource-server 			    | 8675  | Resource Server                      |100%    |
| news-web-app 				    | 8676  | App controller                       |100%    |
| news-web-admin       			    | 8677  | Admin controller                     |100%    |
| news-ms-support 			    | 8678  | Support service                      |100%    |
| news-ms-content           		    | 8679  | Content service                      |100%    |
| news-canal           		    | none  | mysql to elasticsearch                      |0%    |

## <a name="7">Database</a>(<a href="./db/newsdb-init.sql">sql here</a>)

* n_user(user information)

| field name                              	| type          | describe                             | 
| ------------------------------------------| --------------| ------------------------------------ | 
| n_id                	    				| bigint  	    | unique id(not null)				   |
| n_account               	    			| varchar(50)   | user account(not null & unique)      |
| n_password               		    		| varchar(100)  | user password encrypt(not null)      | 
| n_type        		    				| enum		    | user type enum(APP,ADMIN)            |
| n_create 			    					| datetime	    | create time(default current time)    |
| n_create_by 				    			| varchar(50)   | create by 	                       |
| n_modified       			    			| datetime  	| modified time  		               |
| n_modified_by 			    			| varchar(50)  	| modified by       	               |

* n_news(news )

| field name                              	| type          | describe                             | 
| ------------------------------------------| --------------| ------------------------------------ | 
| n_id                	    				| bigint  	    | unique id(not null)				   |
| n_title               	    			| varchar(50)   | news title(not null)                 |
| n_tag		               		    		| varchar(100)  | news tags  						   | 
| n_content        		    				| text		    | news content(not null)   			   |
| n_create 			    					| datetime	    | create time(default current time)    |
| n_create_by 				    			| varchar(50)   | create by 	                       |
| n_modified       			    			| datetime  	| modified time  		               |
| n_modified_by 			    			| varchar(50)  	| modified by       	               |

## <a name="8">How to Run</a>

    1.Create db with sql(newsdb-init.sql)
    2.git clone https://github.com/4KingSe7en/Demos.git
	3.mvn clean package
	4.修改数据库配置（news-ms两个服务），redis配置（news-auth-server），配置中心目前设置的是(https://github.com/4KingSe7en/Demo-config)需要自己更改一下
	5.java -jar news-service-registry-0.0.1-SNAPSHOT.jar #注册中心
	6.java -jar news-config-server-0.0.1-SNAPSHOT.jar #配置中心
	7.java -jar news-gateway-0.0.1-SNAPSHOT.jar #API 网关
	8.java -jar news-auth-server-0.0.1-SNAPSHOT.jar #认证中心
	9.java -jar news-web-app-0.0.1-SNAPSHOT.jar #app web接口
	10.java -jar news-web-admin-0.0.1-SNAPSHOT.jar #admin web接口
	11.java -jar news-ms-content-0.0.1-SNAPSHOT.jar #内容微服务接口
	12.java -jar news-ms-support-0.0.1-SNAPSHOT.jar #支撑相关微服务接口

## <a name="9">Code coverage report</a>

* <a href="./coverage%20report/news-service-registry">news-service-registry(71.4%)</a>
* <a href="./coverage%20report/news-config-server">news-config-server(75.%)</a>
* <a href="./coverage%20report/news-gateway">news-gateway(89.1%)</a>
* <a href="./coverage%20report/news-auth-server">news-auth-server(74%)</a>
* <a href="./coverage%20report/news-web.app">news-web-app(93.9%)</a>
* <a href="./coverage%20report/news-web-admin">news-web-admin(95.5%)</a>
* <a href="./coverage%20report/news-ms-content">news-ms-content(90%)</a>
* <a href="./coverage%20report/news-ms-support">news-ms-support(91.2%)</a>

## <a name="9">interface doc</a>

	#user regist
    curl --location --request POST 'http://127.0.0.1:8673/user/regist' \
    --header 'Content-Type: application/json' \
    --data-raw '{
      "account":"1111112",
      "pwd":"1111111",
      "type":"APP"
    }'


	#user login
    curl --location --request POST 'http://127.0.0.1:8673/login' \
	--header 'Content-Type: application/json' \
	--data-raw '{
	  	"account":"1111112",
	  	"password":"1111111",
	  	"type":"APP"
	}'
    
	#app user search
	curl --location --request GET 'http://127.0.0.1:8673/app/news' \
	--header 'Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJTUEgiLCJpc3MiOiJTUEgiLCJuYW1lIjoiMTExMTExMiIsImV4cCI6MTU5NDA0MDMzNiwiaWF0IjoxNTk0MDM3MzM2fQ.wB_VkPhmcuF-1ZyEU-zAV52pYa8ns-d53rVfOPKQI6o' \
	--header 'Content-Type: application/json' \

	#app user getNews
	curl --location --request GET 'http://127.0.0.1:8673/app/news/1' \
	--header 'Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJTUEgiLCJpc3MiOiJTUEgiLCJuYW1lIjoiMTExMTExMiIsImV4cCI6MTU5NDA0MDMzNiwiaWF0IjoxNTk0MDM3MzM2fQ.wB_VkPhmcuF-1ZyEU-zAV52pYa8ns-d53rVfOPKQI6o' \
	--header 'Content-Type: application/json' \

	#Admin search
	curl --location --request GET 'http://127.0.0.1:8673/admin/news' \
	--header 'Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJTUEgiLCJpc3MiOiJTUEgiLCJuYW1lIjoiMTExMTExMiIsImV4cCI6MTU5NDA0MDMzNiwiaWF0IjoxNTk0MDM3MzM2fQ.wB_VkPhmcuF-1ZyEU-zAV52pYa8ns-d53rVfOPKQI6o' \
	--header 'Content-Type: application/json' \

	#Admin getNews
	curl --location --request GET 'http://127.0.0.1:8673/admin/news/1' \
	--header 'Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJTUEgiLCJpc3MiOiJTUEgiLCJuYW1lIjoiMTExMTExMiIsImV4cCI6MTU5NDA0MDMzNiwiaWF0IjoxNTk0MDM3MzM2fQ.wB_VkPhmcuF-1ZyEU-zAV52pYa8ns-d53rVfOPKQI6o' \
	--header 'Content-Type: application/json' \

	#Admin NEW
	curl --location --request POST 'http://127.0.0.1:8673/admin/news/' \
	--header 'Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJTUEgiLCJpc3MiOiJTUEgiLCJuYW1lIjoic3BoIiwiZXhwIjoxNTk0MDQ2MDY5LCJpYXQiOjE1OTQwNDMwNjl9.VD4YPdMAOqhPBkanj54Zg41zdnztSp52jQDfWnO42zU' \
	--header 'Content-Type: application/json' \
	--data-raw '{
	    "title": "O111",
	    "tag": "222221111",
	    "content": "TH12312321"
	}'

    #Admin update
	curl --location --request PUT 'http://127.0.0.1:8673/admin/news/' \
	--header 'Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJTUEgiLCJpc3MiOiJTUEgiLCJuYW1lIjoic3BoIiwiZXhwIjoxNTk0MDQ2MDY5LCJpYXQiOjE1OTQwNDMwNjl9.VD4YPdMAOqhPBkanj54Zg41zdnztSp52jQDfWnO42zU' \
	--header 'Content-Type: application/json' \
	--data-raw '{
	    "uuid":20,
	    "title": "O33333",
	    "tag": "222221111",
	    "content": "TH12312321"
	}'
	
	#Admin delete
	curl --location --request DELETE 'http://127.0.0.1:8673/admin/news/1' \
	--header 'Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJTUEgiLCJpc3MiOiJTUEgiLCJuYW1lIjoic3BoIiwiZXhwIjoxNTk0MDQ2MDY5LCJpYXQiOjE1OTQwNDMwNjl9.VD4YPdMAOqhPBkanj54Zg41zdnztSp52jQDfWnO42zU' \
	--header 'Content-Type: application/json' \
	--data-raw '{
	    "title": "Open Source Search: The Creators of",
	    "tag": "https://www.elastic.co",
	    "content": "Elasticsearch, Kibana, Beats, and Logstash. Securely and reliably search, analyze, and visualize your data in the cloud or on-prem."
	}'

