# publisher-back

This project runs on Tomcat server on port 8080


Endpoint to run this project is: http://localhost:8080/

# Docker-compose file settings

At the root of the project, run this command to start the containers:

     docker-compose up -d

To access pgadmin in the browser, open:

     http://localhost:8081

Enter the following access data:

     user: publisher
     password: publisher

Click *Add new server* and, on the Connection tab, fill in the parameters:

     host: postgres
     port: 5432
     username: postgres
     password: postgres

The docker-compose file will automatically generate the publisher database as a suggestion for our application, from the createDb.sql file.

To stop the containers, run:
    
    docker-compose stop

If you want to stop and delete the containers, run:
    
    docker-compose down