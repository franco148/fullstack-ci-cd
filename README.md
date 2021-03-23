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


















