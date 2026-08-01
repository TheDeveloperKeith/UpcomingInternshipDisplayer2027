# UpcomingInternshipTracker2027
A Java Spring Boot Project leveraging Spring Boot, Maven, Rest Api Fundamentals, MYSQL, and HTML to build a full stack application that will provide users with generic internship opportunities based on their language of choice.

To run this project, Clone the repository into Intellij Idea as an existing SpringBoot Maven Project. (Note this specfiic build uses SpringBoot 4.1, and Java 17).




Firstly, the technologies used here were specifically meant for learning each of these tools/frameworks here and getting some type of experience with the Spring Boot framework and Maven dependencies. For Context, I had a strong sense of my Java language fundamentals before starting to work on this project but lacked understanding of Maven, Spring Boot, HTML, and SQL/MYSQL so this project was the bridge for those gaps as I aim to become a Spring Boot developer. Some will question the decision to use MYSQL here, and the intention of the project was to help become familiar with MYSQL as I used it, however if I had to go back, I'd choose a different database like PostgreSQL because of MYSQL limitations that changed the way I worked on this project. 

The actual Project showcases different internship opportunities for different interns looking for different internship opportunities, specifically Java, C++, JavaScript, or multiple languages. I queried MYSQL to create a database of internship names and primary programming languages attached to them, after that I connected my database to my IDE (IntelliJ Idea). The project will then go through the Spring Boot Framework and three classes: the Entity class (internship table), the repository class (Internship), and the Controller Class (Internship Rest Controller). The MYSQL data will be pulled from the entity, and the repository will be the bridge connection between the controller and entity. From there, the rest controller will handle the get request logic for the html. The HTML will finally handle the values at the end and use them to create a front-end that showcases the internships. 

Users will be able to click on a link pointing to internships/careers offered by the company as presented in the icon of that company. 

Note, some of my significant challenges when creating this project were figuring out the logic in Spring Boot and handling the MYSQL database. Spring Boot is very different than standard Java code taught within a course or a textbook. Some of the streams, annotations, generic parameters, and lambda expressions were familiar to me, but a lot of the logic was not and took a decent chunk of time to figure out the structure and purpose of the different things within Spring Boot, with the help of documentation and Stack Overflow. Additionally, the use of MySQL here was a significant constraint in the project. If I hadn't included it just to learn it, I wouldn't have used it at all or opted for a different database due to its relational database properties. Despite all struggles, near the end, when I was messing with the html was some of the most fun I had, and debugging the Spring Boot Controller logic was troublesome yet rewarding to my understanding of the framework.


