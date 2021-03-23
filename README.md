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