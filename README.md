Spring Boot – CRUD Operations Using Redis as a Database
------------------------------

How to perform CRUD in Spring Boot using Redis as a Database. Alternatively, Redis has many use cases some are listed such as Database , Cache , Message Broker


Prerequisites:

You need to have Redis installed and running.

You should have Spring Boot configured in your environment.

Step-by-Step Implementation:
1. Create a Spring Boot Project with the necessary dependencies (Spring Data Redis, Spring Boot Starter Web).
2. Configure Redis in application.properties
3. Create a Redis Configuration Class to define a Redis template and a connection factory to interact with Redis.
4. Create the Model Class (Employee)
5. Create the Repository Class and use RedisTemplate to perform CRUD operations on Redis.
6. Create a Controller Class will expose CRUD operations via REST endpoints.
7. Run the Application

![image](https://github.com/user-attachments/assets/f0af34fd-c388-4658-bb7f-b54b73f6e4c9)


![image](https://github.com/user-attachments/assets/d6a7eda4-b611-4b63-a058-e31d1983b0be)


-------------------------------

To view the employee data stored in Redis, you can use the Redis CLI (redis-cli). Here’s how you can do that:
1. Access the Redis CLI: Open a terminal or command prompt and run the Redis CLI command - redis-cli
2. Test the connection -

   ![image](https://github.com/user-attachments/assets/9481e5d7-06f3-43b2-a833-86dea83cd255)

   
2. List All Keys -
   
   ![image](https://github.com/user-attachments/assets/cd020d4b-3900-4825-b3dc-7b0bd19e8215)

3. Check All Employees -

   ![image](https://github.com/user-attachments/assets/d1760306-0d27-4235-8b7b-1cbd2abe93ba)

4. Check a Specific Employee by ID: HGET EMPLOYEE 1
5. Delete employee by empId: HDEL EMPLOYEE 1



   
