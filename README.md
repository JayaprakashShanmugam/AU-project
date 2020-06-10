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

Repository : Opportunity Dao

    Functions: 
       1. getOpportunities return type<List> - returns all the opportunities in DB using JDBC Templte(selectall).
       2. getId return type<Opportunity> - returns a single row of opportunity with specified id in DB using JDBC Templte(select).
       3. add return type<int> - adds new Opportunity attributes in DB using JDBC Templte(update).
       4. update return type<int> - updates the Opportunity attributes with specified id in DB using JDBC Templte(update).
       5. delete return type<int> - deletes the Opportunity attributes with specified id in DB using JDBC Templte(delete).
       
Controller : Opportunity Controller
 
    Functions: 
       1. getOpportunities return type<List> - calls getOpportunities method in OpportunityDao.
       2. getId return type<Opportunity> - calls getId method in OpportunityDao.
       3. addOpportunity return type<String> - calls add method in OpportunityDao.
       4. updateOpportunity return type<String> - calls update method in OpportunityDao.
       5. deleteOpportunity return type<String> - calls delete method in OpportunityDao.
       
 Exception : Opportunity Exception Controller
 
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
             
             Functions: 
       1. getOpportunityTest - expects opportunity for specific id.(get)
       2. getAllOpportunityTest - expects all opportunities.(get)
       3. addOpportunity - expects on adding opportunity status.(post)
       4. updateOpportunity - expects on updating opportunity status for specific id.(put)
       5. deleteOpportunity - expects on deleting opportunity status for specific id.(delete)
       
       2. Opportunity Dao Test - fused for testing each function in Opportunity Dao.
      
              Functions: 
       1. getAllOpportunity - expects all opportunities using dao.getOpportunities.(select)
       2. addOpportunity - expects on adding opportunity using dao.add.(update)
       3. updateOpportunity - expects on updating opportunity using dao.update.(update)
       4. deleteOpportunity - expects on deleting opportunity using dao.delete.(delete) 
  
  
  #  Angular Stack
  
      Components:
         1.login-user - for Google Login.
         2.userhome - for Creating opportunities.
         3.trendstable - for displaying opportunities
         4.trends - for displaying trends charts.
        
       Services:
          1.Opportunity Service: for GET,PUT,POST,DELETE Opportunities
          2.LoginUser Service : for VALIDATE user
          
       Classes:
          1.Opportunity : oid,description,location,skills,openingDate,projectDuration,lastDate,experience,managerName,managerEmail
          2. Login : firstName,Lastname,email
          3. Interceptor : intercepts each http request and add a user token to each request header. 

       Testing:
          1.Form testing : (FormsModule) expects te form to be empty during initialization and for checking the validation.
          2.Filter testing : expects to give the filtered text and return that number of rows.
          3.Services testing : Testing Opportunity (GET,PUT,POST,DELETE) and Login user services.


