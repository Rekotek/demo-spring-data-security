# Demo of various Spring technologies

Spring Boot, Spring Data, Spring MVC + Thymeleaf, Spring Security, AJAX and so on...

---

First of all, this is *demo project*, not *production project*, so this demo intentionally built piece-by-piece and
included various examples, sometimes over-engineered, that can be used for real project.

For example, for `Spring Security` you can find how to protect information using roles and also how to do it using inheritance of `User` class.

### Business objectives and goals
Imagine, that we have small factory that repair goods. The boss wants to have enterprise web application
to control overall process and also to inform clients about their orders. Workers and clients can write comments
about every order.

Client has it's own Manager who organizes overall process. Manager wants to see what's going on with orders
 he has put down, and Employee have to be aware about it's future plan.
 
###Branches
I'm not sure, but probably I'll build this example app using `git branch`. 

###Business entities
We have `Manager` with several `Employee` which are managed by him. When new `Customer` call and ask for
help, `Manager` creates new record about `Customer` and put down new `Order`. `Customer` become aware of this `Order`
 and later can see progress in work on website.
 
 `Manager` also break this order to several `OrderTask`,
 making timetable and bind every `Task` to appropriate `Employee`.
 
 `Admin` creates new `Manager` and `Employee`.
 
 Every person (`Manager`, `Employee`, `Customer`, `Admin`) can write comments to the `Order`.
  
###Package description
1. `org.tutorial.configs` includes `DataInitializer` for loading test data into database.
And also it includes `WebSecurityConfig` where you can find example how to create Security Configuration.

   Here I'm using `@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)`
   that allows me to use `Spring Security` for protecting service methods.

   Also pay attention on how to add usage of password encoder.

2. `org.tutorial.core` represents business tier of this app.

   Pay attention on `org.tutorial.core.entities.personalities.PersonCore` — it has 2 `@Embedded Address` properties,
 and to use it with JPA you should tell how to name columns in DB.
   
3. `org.tutorial.web` represents WebMVC tier.
   - `org.tutorial.web.auth` includes services and special entity objects for `Spring Security` usage.
     
     Since we have several type of loggable users, I inherited different type of classes from `Spring Security's`
     `org.springframework.security.core.userdetails.User` class. For creating special type of user, I use 
     `org.tutorial.web.auth.AuthSpecPersonFabric` builder.

     `org.tutorial.web.auth.LoggedUserHelper` shows how to retrieve various information from 
     authorized User.
      
   - `org.tutorial.web.controllers.advices.ExceptionsController` shows how to use `@ControllerAdvice` and `@ExceptionHandler`.