# AU-project
Accolite User Management System

# Tech Stack
      Angular - Frontend
      SpringBoot -Backend
      mySQL - DB

#  Spring Boot Stack
Entity : Opportunity model

    Attributes: oid,description,location,skills,openingDate,projectDuration,lastDate,experience,managerName,managerEmail

RowMapper : Opportunity RowMapper for mapping each row to mySQLDB.

    Functions : OpportunityRowmapper - used for iterating each rows in mysqlDB [opportunity]

Repository : Opportunity Dao

    Functions: 
       1. getOpportunities return type<List> - returns all the opportunities in DB using JDBC Templte(selectall).
       2. getId return type<Opportunity> - returns a single row of opportunity with specified id in DB using JDBC Templte(select).
       3. add return type<int> - adds new Opportunity attributes in DB using JDBC Templte(update).
       4. update return type<int> - updates the Opportunity attributes with specified id in DB using JDBC Templte(update).
       5. delete return type<int> - deletes the Opportunity attributes with specified id in DB using JDBC Templte(delete).
       
Service : Opportunity Service [middleware between Dao and Controller]
 
    Functions: 
       1. OpportunityInformationService return type<List> - calls getOpportunities method in OpportunityDao.
       2. getIdService return type<Opportunity> - calls getId method in OpportunityDao.
       3. addOpportunityService return type<String> - calls add method in OpportunityDao.
       4. updateOpportunityService return type<String> - calls update method in OpportunityDao.
       5. deleteOpportunityService return type<String> - calls delete method in OpportunityDao.   
       
Controller : Opportunity Controller
 
    Functions: 
       1. getOpportunities return type<List> - calls OpportunitiesInformationService method in OpportunityService.
       2. getId return type<Opportunity> - calls getIdService method in OpportunityService.
       3. addOpportunity return type<String> - calls addOpportunityService method in OpportunityService.
       4. updateOpportunity return type<String> - calls updateOpportunityService method in OpportunityService.
       5. deleteOpportunity return type<String> - calls deleteOpportunityService method in OpportunityService.
       
 Exception : Opportunity Exception Handler
 
    Exceptions: 
       1. OpportunityNotFoundException - handles HTTP NOT_FOUND Exception.
       2. OpportunityServiceErrorException - handles HTTP INTERNAL_SERVER_ERROR Exception.
       
     Error Logging: Logs HTTP Exceptions and shows response message. 
     
 Configuration : Web Security Configuration
 
    Does not allows all the origins.
    Set Allowed Origins : localhost:4200(angular),localhost:8080(springboot).
    Set Allowed Methods : "GET", "PUT", "POST", "PATCH", "DELETE", "OPTIONS".
    
 Authentication : Google Sign In
 
      Functions: 
       1. ValidateUser in OpportunityController - used for validating each request sent by the user by intercepting the user token.
       2. UpdateUser in OpportunityDao - for checking the specific tokn in DB using JDBC Template(update).
       
  Testcases : Opportunity Application Tests
 
      Classes: 
       1. Opportunity Controller Test  - used for testing each request in controller.
           
           getOpportunityforTest() - a helper method used for reusing opportunity instance in all test classes.  
             
             Functions: 
       1. getOpportunityById_OpportunityIdValue_ReturnsSingleObject - expects opportunity for specific id.(get)
       2. getAllOpportunity_ObjectListValues_ReturnsListSize - expects all opportunities.(get)
       3. addOpportunity_SingleObject_ReturnsHttpStatus - expects on adding opportunity status.(post)
       4. updateOpportunity_SingleObject_ReturnsHttpStatus - expects on updating opportunity status for specific id.(put)
       5. deleteOpportunity_OpportunityIdValue_ReturnsHttpStatus - expects on deleting opportunity status for specific id.(delete)
       6. validateUser_UserObjectValues_ReturnsString - expects on validating and updating user details for specific usertoken.(update)
       
       2. Opportunity Service Test - used for testing each function in Opportunity Service.
      
              Functions: 
       1. getAllOpportunities_ObjectList_ReturnsListSize - expects all opportunities using OpportunityInformationService.(select)
       2. addOpportunity_SingleObject_ReturnsOne - expects on adding opportunity using addOpportunityService.(update)
       3. updateOpportunity_SingleObject_ReturnsOne - expects on updating opportunity using updateOpportunityService.(update)
       4. deleteOpportunity_OpportunityIdValue_ReturnsOne - expects on deleting opportunity using deleteOpportunityService.(delete) 
  
       3. Opportunity Dao Test - used for testing each function in Opportunity Dao.
      
              Functions: 
       1. getAllOpportunities_ObjectList_ReturnsListSize - expects all opportunities using dao.getOpportunities.(select)
       2. addOpportunity_SingleObject_ReturnsOne - expects on adding opportunity using dao.add.(update)
       3. updateOpportunity_SingleObject_ReturnsOne - expects on updating opportunity using dao.update.(update)
       4. deleteOpportunity_OpportunityIdValue_ReturnsOne - expects on deleting opportunity using dao.delete.(delete) 
  
  
  #  Angular Stack
  
      Components:
         1.login-user - for Google Login.
         2.userhome - for Creating opportunities.
         3.trendstable - for displaying opportunities
         4.trends - for displaying trends charts.
        
       Services:
          1.Opportunity Service: for GET,PUT,POST,DELETE Opportunities
          2.LoginUser Service : for VALIDATE user
          
       Models:
          1.Opportunity : oid,description,location,skills,openingDate,projectDuration,lastDate,experience,managerName,managerEmail
          2.Login : firstName,Lastname,email
          
      Interceptors:
          1.Interceptor : intercepts each http request and add a user token to each request header. 

       Testing:
          1.Form testing : (FormsModule) expects te form to be empty during initialization and for checking the validation.
          2.Filter testing : expects to give the filtered text and return that number of rows.
          3.Services testing : Testing Opportunity (GET,PUT,POST,DELETE) and Login user services.


