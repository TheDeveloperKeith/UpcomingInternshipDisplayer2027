UpcomingInternshipDisplayer2027
A Spring Boot REST API + MySQL application that tracks some of the latest internships coming in 2027. Built with Java, Spring Boot, and SQL, and fully containerized with Docker.
Repo: https://github.com/TheDeveloperKeith/UpcomingInternshipDisplayer2027
---
Tech Stack
Backend: Java 17, Spring Boot, Maven
Database: MySQL 8.0
Containerization: Docker & Docker Compose
---
Prerequisites
Before you begin, make sure you have installed:
Docker
Docker Compose (bundled with Docker Desktop)
Git
Verify your install:
```bash
docker --version
docker compose version
```
---
1. Clone the Repository
```bash
git clone https://github.com/TheDeveloperKeith/UpcomingInternshipDisplayer2027.git
cd UpcomingInternshipDisplayer2027
```
---
2. Configure Environment Variables
The project ships with a template env file (`_env`). Docker Compose only reads a file literally named `.env` in the project root, so it must be renamed:
```bash
# macOS / Linux
mv _env .env

# Windows (PowerShell)
Rename-Item _env .env
```
Open `.env` and fill in your own values. Example:
```dotenv
# MySQL container settings
MYSQL_ROOT_PASSWORD=newPass
MYSQL_DATABASE=mydb

# Spring Boot app settings — must match the MySQL settings above
DB_HOST=mysqldb
DB_PORT=3306
DB_NAME=mydb
DB_USER=root
DB_PASSWORD=newPass
```
> ⚠️ **`MYSQL_DATABASE` and `DB_NAME` must be identical.** `MYSQL_DATABASE` is the name MySQL creates on first boot; `DB_NAME` is the name the Spring Boot app connects to. If they don't match, the app container will start, fail to connect to its expected schema, and immediately exit — which looks like the app "shutting itself down."
>
> Similarly, `DB_PASSWORD` should match `MYSQL_ROOT_PASSWORD` (or whichever MySQL user you configure), and `DB_USER` must be a valid MySQL user with access to that database.
`.env` contains secrets and should never be committed — confirm it's listed in `.gitignore`.
---
3. Build and Launch the Containers
From the project root (same folder as `docker-compose.yaml`):
```bash
docker compose up --build
```
This will:
Build the Spring Boot app image from the `Dockerfile` (Maven build stage → JRE runtime stage).
Pull and start a `mysql:8.0` container.
Wait for MySQL to report healthy (via its healthcheck) before starting the app, since `app` depends on `mysqldb`'s `service_healthy` condition.
Run `seed.sql` automatically on the database's first initialization, creating the `internshipwebsites` table and seeding it with sample internship data.
Expose the app on your host machine.
To run in the background instead:
```bash
docker compose up --build -d
```
---
4. Access the App
Once both containers are up, the API is available on your host at:
```
http://localhost:8081
```
(Port `8081` on your host maps to port `8080` inside the app container, as set in `docker-compose.yaml`.)
Check container status and logs:
```bash
docker compose ps
docker compose logs app
docker compose logs mysqldb
```
---
5. Stopping the Project
```bash
# Stop containers, keep data
docker compose down

# Stop containers and wipe the database volume (fresh reseed next run)
docker compose down -v
```
> If you change `MYSQL_DATABASE`, `MYSQL_ROOT_PASSWORD`, or edit `seed.sql` after the first run, use `docker compose down -v` before `docker compose up --build` again. MySQL only runs its init scripts (including `seed.sql`) the **first time** a fresh volume is created — an existing `mysql-data` volume will ignore changes to these values.
---
Troubleshooting
Symptom	Likely Cause
App container starts then exits immediately	`.env` is missing/misnamed, or `DB_NAME` ≠ `MYSQL_DATABASE`
App can't connect to DB / connection refused	`mysqldb` isn't healthy yet, or `DB_HOST` doesn't match the service name (`mysqldb`) in `docker-compose.yaml`
Seed data missing from `internshipwebsites` table	The MySQL volume already existed from a previous run — run `docker compose down -v` to reset it
Port `8081` already in use	Another process is bound to that port on your host — change the left-hand side of `"8081:8080"` in `docker-compose.yaml`
---
Project Structure
```
.
├── Dockerfile              # Multi-stage build: Maven build → JRE runtime
├── docker-compose.yaml     # Defines app + mysqldb services
├── seed.sql                # Creates & seeds internshipwebsites table
├── .env                    # Local environment config (create from template, not committed)
└── src/
    └── main/
        ├── java/           # Entity, Repository, and Controller classes
        └── resources/
            └── static/     # Front-end HTML
```
---
How It Works
The app queries a MySQL database of internship names paired with their primary programming language (Java, C++, JavaScript, or general/multiple), then serves that data through a Spring Boot REST API to a simple front end.
The Spring Boot layer follows a standard three-tier structure:
Entity class — maps the `internshipwebsites` table to a Java object.
Repository class — the data-access layer; bridges the Entity and Controller.
REST Controller class — handles incoming GET requests and returns internship data to the front end.
The front-end HTML consumes that data and renders each internship as a clickable icon linking out to that company's internships/careers page.
---
About This Project
This project was built primarily as a learning exercise — a way to get hands-on experience with Spring Boot, Maven, HTML, and SQL/MySQL on top of an already solid foundation in core Java.
A few notes for anyone browsing the code or curious about the "why" behind some decisions:
Why MySQL? The goal was specifically to get familiar with MySQL. In hindsight, PostgreSQL would likely have been a better fit for this project — MySQL's relational constraints shaped (and occasionally complicated) the schema and query design in ways that added friction without adding much learning value beyond the basics.
Database → IDE → Framework pipeline: The database was first built and queried directly in MySQL, then connected to IntelliJ IDEA. From there, the data flows through Spring Boot's Entity → Repository → Controller pipeline described above, and finally out to the HTML front end.
Biggest challenges: Spring Boot's structure and conventions (dependency injection, annotations, the overall request lifecycle) were a significant departure from textbook Java, even though individual Java features like streams and lambdas were already familiar. Getting comfortable with why Spring Boot is structured the way it is took real time, documentation, and a fair amount of Stack Overflow.
Most rewarding parts: Building out the front-end HTML and getting the REST Controller logic working end-to-end were the most satisfying parts of the project — frustrating in the moment, but the payoff in understanding was worth it.
If you're also learning Spring Boot for the first time, hopefully this repo (warts and all) is useful as a reference for how the pieces fit together.


