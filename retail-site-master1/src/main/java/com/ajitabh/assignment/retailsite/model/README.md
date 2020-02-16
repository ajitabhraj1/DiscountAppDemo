Assumptions :



1. User can either be an employee, affiliate or a customer .(One to One mapping with Role)
2. The person will know before calculation what is the type of user (Employee, Affiliate or Customer)


Note: In order to run the project, kindly download the source code and run the application as Spring Boot application (runnning with RealSiteApplication.java).

 I have assumed that the 5$ discount per 100$ total bill for a customer/
 employee/Affiliate will be made on the total bill and then if any other 3 discounts(% discounts) will be made as per UserType based on Employee(30%),
 Affiliate(10%) and customers(loyalty>2 years 5%) on the non grocery items.
 
 
 I have used inmemory database for running the application which can be configured using configuration already provided in the application.properties.
 
 