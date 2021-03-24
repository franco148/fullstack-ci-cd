Mac
- ./mvnw jib:dockerBuild -Djib.to.image=fullstack:v1
- ./mvnw clean install jib:dockerBuild -Djib.to.image=fullstack:v1

Windows
- mvnw jib:dockerBuild -Djib.to.image=fullstack:v1
- mvnw clean install jib:dockerBuild -Djib.to.image=fullstack:v1

To run container
- docker run --name fullstack -p 8080:8080 fullstack:v1

To delete container with name fullstack
- docker rm -f fullstack 

To view local images run
- docker image ls

To view running containers
- docker ps 


Commands used: 
- docker login 
- docker pull 
- docker rm -f id 
- ./mvnw clean install jib:build -Djib.to.image=amigoscode/spring-react-fullstack:latest 
- ./mvnw clean install jib:build -Djib.to.image=amigoscode/spring-react-fullstack:latest -D jib.to.auth.username=amigoscode -Djib.to.auth.password=yourpassword 
- docker pull amigoscode/spring-react-fullstack:latest 
- docker run -p 8080:8080 amigoscode/spring-react-fullstack 


Commands used: 

./mvnw clean install -P build-frontend -P jib-push-to-dockerhub -Dapp.image.tag=2
./mvnw clean install -P build-frontend -P jib-push-to-local -Dapp.image.tag=latest


Postgres in Docker:
- https://hub.docker.com/_/postgres

- docker network create db
- Create a folder for the container volume, and go in it.

- 1. create a folder to mount /var/lib/postgresql/data
- 2. cd into that folder
- 3. docker run --name db -p 5432:5432 --network=db -v "$PWD:/var/lib/postgresql/data" -e POSTGRES_PASSWORD=password -d postgres:alpine

- docker run -it --rm --network=db postgres:alpine psql -h db -U postgres














