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

## <a name="4">Mysql to ElasticSearch </a>

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

## <a name="9">Code coverage report</a>
