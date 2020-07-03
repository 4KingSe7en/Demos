# Demos For News

![codecov]

Code for myself

* <a href="#1">Architectural</a>
* <a href="#1">App User flow path</a>
* <a href="#1">Admin User flow path</a>
* <a href="#1">Modules</a>
* <a href="#1">Use </a>
* <a href="#1">Code coverage report</a>

## Technology stack

* Spring boot 2.1.6.Release
* Spring clound Finchley.SR3
* Alibaba Druid 1.1.10
* Mybatis plus 3.1.0
* Mybatis 3.5.1
* Redis 4.0
* Mysql 5.7
* ElasticSearch 

## <a name="1">Architectural</a>

![platform](./architecture.jpg)

## App User flow path

![flow](./appflow.jpg)

## Admin User flow path

![flow](./adminflow.jpg)

## Modules
  
- news-parent
	- news-service-registry (*Service Register And Discovery Center*)
	- news-config-server (*Configuration Center*)
	- news-gateway (*API Gateway*)
	- news-auth-server (*Authorization server*)
	- news-resource-server (*Resource server*)
	- news-web-layer (*Interface for APP & admin*)
		- news-web-app (*Interface for app*)
		- news-web-admin (*Interface for admin*)
	- news-ms-layer (*Micro Service*)
		- news-ms-support (*Support Service*)
		- news-ms-content (*Content Service*)