# Twitter+
This Java Web project implements some APIs of Twitter, such as user signin/signup, posting
/
deleting
/
commenting
/
liking 
/
unliking a post. The development tools include Spring Boot, MyBatis, MySQL, Redis, Quartz Scheduler, Websocket. 



#Project Configurations
Initiated a Spring Boot project from https://start.spring.io/.
Utilized Maven to manage the development of this project. 

pom.xml file includes dependencies such as MySQL driver, MyBatis, Redis, WebSocket, quartz-scheduler etc.

#Project Architecture
Created controller, service, dao and model(entity) layers.
Configured controllers with @RequestMapping, @RequestParams, @RequestBody annotations. 



#Database Development
Constructed database and tables with MySQL. SQL files are located in src/resources/sql

database: Twitter

tables: Users, Tweets, Notifications, Likes, Comments, Follower_Followee.



