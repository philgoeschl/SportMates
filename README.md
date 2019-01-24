# SportMates
This web application helps athletes to find other athletes doing the same sports.
As a user, you can create a profile where you can specify your favorite sports. Furthermore, the users can create different events, for example, for joint training. At the events the users can participate and this will then be displayed in their user profiles.
The administrator can add sports, manage users and events.

## Team members
- Lukas David
- Philipp Göschl
- Teresa Neuhold

## Work load distribution
- Lukas David
  - CRUD User entity, User-Profile, User-List, Registration, Admin Guard
- Philipp Göschl
  - CRUD Event entity, Event-Form, Event-List, Event-Details, Event Search
- Teresa Neuhold
  - CRUD Sport entity, Sport-Form, Sport-List, Design
  
## Required Software
- JAVA 8 SDK

- IntelliJ IDEA Install the Spring Boot Plugin (ALL SPRING Plugins should be enabled)

## Additional Requirements
- MySQL Server

## Instalation
- Clone this repository to your local machine
- In the backend folder change the application.properties file
  - src\main\ressources
-in the frontend folder run 'npm install'

### Open in IDE IntelliJ
- File -> Open -> Select backend directory -> OK (if requested open in new window)
- File -> Open -> Select frontend directory -> OK (if requested open in new window)

### Run the Project
- backend: Start Spring Boot REST Application
- frontend: Start via Angular CLI (ng serve --open)
- Check application running on http://localhost:4200 in browser
  - Default Admin:
    - Username: admin
    - Password: 12345
  - Default User:
    - Username: tester
    - Password: 12345
