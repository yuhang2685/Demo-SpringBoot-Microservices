# Demo-SpringBoot-Microservices

Author: Dr. YUHANG ZHAO

Introduction:
In this demo we illustrate how to build microservices with Spring Boot and Spring cloud.

Reference: "Spring Boot Microservices Level 1" by Java Brains

Overview:
01. In general, microservice changes what happens in the runtime, not only the architecture? but also the thinking of programming.

    We'll be creating a few microservices and then have them communicated with each other. 
    In the process, we'll understand how inter-service communication work, and we'll implement "service discovery" with Eureka to facilitate services discoverying each other to communicate.

    Spring Cloud is one way to do microservice.

02. Advantage is independent, scalability; 
    disadvantage is the problems in general such as "load balancing".

    In other words, monolith: "complexity hidden with"; microservice: "complexity between microservices".

03. Monolith -> pieces (microservices); service discovery; how to communicate each other.

04. Spring Cloud is one way to do microservice.

    Prerequisites for this demo: Java and Spring Boot, since microservice is a SpringBoot app.
    
    Demo: a movie catalog API application.

05. Each microservice is a spring boot project.

06.

07.

08.

09.

10. So far we have constructed 3 applications independently with hard-coded data.
    
    Discuss we are going to call each other programatically through REST APIs using REST client library.
    Spring Boot has one client (to do REST API calls) already in your classpath - RestTemplate, we use it to call an external microservice API.

11. Implement using RestTemplate to call an external microservice API - movie info service.

12. Use @Bean for RestTemplate.

13. Use webClient (asynchronous) to make API calls instead of RestTemplate (synchronous).

14. Make an API accepting user ID and returns a list of movie ID.

15. Why should avoid returning list in APIs?
    and how?: use object to wrap list of objects.
    
17. Dynamic url in cloud;
    load balancing needed;
    Then how to? the discovery server, which is like a phone book.
    Spring Boot and Spring Cloud use Client side discovery, which requests the discovery server and jump to the supplied url.
    
    Eureka, as Ribbon, Hysterix, Zuul, belongs to Netflix OSS.

18. Discuss we will set up Eureka server, register the 3 microservices in it as Eureka clients.
    Also, who needs Eureka services is also an Eureka client.
   
19. Start up a Eureka server:
    Spring Boot Starter Project using Eureka Server; @EnableEurekaServer; check port 8761 for Dashboard;
    Error in console solved by adding in application properties that stop acting as a client.

20. Have microservices registered (publish) using Eureka client:
    Add dependency; Add application name in application.properties.

21. Have microservices located (consume) using Eureka client:
    @LoadBalanced which does everything including locating and load balancing;
    Replace the hard coded URL by the registered microservice name;
    Fixed error caused by application name diff to the registered name.

22. Load balancing:
    How to duplicate a microservice? through java -Dserver.port=? -jar X.jar

Level 2:

04. User themovieDB.org to get movie info by making external RESTful API calls.
