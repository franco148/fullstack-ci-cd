### Mac
- `./mvnw jib:dockerBuild -Djib.to.image=fullstack:v1`
- `./mvnw clean install jib:dockerBuild -Djib.to.image=fullstack:v1`

### Windows
- `mvnw jib:dockerBuild -Djib.to.image=fullstack:v1`
- `mvnw clean install jib:dockerBuild -Djib.to.image=fullstack:v1`

To run container
- `docker run --name fullstack -p 8080:8080 fullstack:v1`
- `docker run --name fullstack -p 8080:8080 --net=host fullstack-ci-cd:v1 (This worked in ubuntu)`

To delete container with name fullstack
- docker rm -f fullstack 

To view local images run
- docker image ls

To view running containers
- docker ps 


Commands used: 
- `docker login` 
- `docker pull` 
- `docker rm -f id` 
- `./mvnw clean install jib:build -Djib.to.image=franco148/fullstack-ci-cd:v1.0` 
- `./mvnw clean install jib:build -Djib.to.image=franco148/fullstack-ci-cd:latest -D jib.to.auth.username=franco148 -Djib.to.auth.password=yourpassword` 
- `docker pull franco148/fullstack-ci-cd:latest` 
- `docker run -p 8080:8080 --net=host franco148/fullstack-ci-cd` 


Commands used: 
- `./mvnw help:active-profiles`
- `./mvnw clean install -P build-frontend -P jib-push-to-dockerhub -Dapp.image.tag=2`
- `./mvnw clean install -P build-frontend -P jib-push-to-local -Dapp.image.tag=latest`

- `docker run --rm -p 8080:8080 franco148/fullstack-ci-cd // This by default is going to execute the LATEST version of the image`.



Postgres in Docker:

- `docker run -it --rm postgres:alpine psql -h aa9320n4muma7h.celswdmxhcr1.eu-west-1.rds.amazonaws.com -U amigoscode -d postgres`

- https://hub.docker.com/_/postgres

- docker network create db
- Create a folder for the container volume, and go in it.

- 1. create a folder to mount /var/lib/postgresql/data
- 2. cd into that folder
- 3. `docker run --name db -p 5432:5432 --network=db -v "$PWD:/var/lib/postgresql/data" -e POSTGRES_PASSWORD=password -d postgres:alpine`

- docker run -it --rm --network=db postgres:alpine psql -h db -U postgres

- https://www.mockaroo.com/


One way to run DEV profile, is configuring it in the Intellij IDE
- Environment Variables: `SPRING_PROFILES_ACITVE=dev`

Executing the correct profile.
- java -jar -Dspring.profiles.active=dev target/fullstack-ci-cd-0.0.1-SNAPSHOT.jar

Connecting to the remote AWS RDS
- docker run -it --rm postgres:alpine psql -h <rds-url-db> -U <database-user> -d postgres



Deploying APP
- Mac
  - ./mvnw clean install -P build-frontend -P jib-push-to-dockerhub -Dapp.image.tag=3

- Windows
  - mvnw clean install -P build-frontend -P jib-push-to-dockerhub -Dapp.image.tag=3



























