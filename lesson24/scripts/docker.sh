docker run --rm \
    --name tomcat \
    --network demo_network \
    -p 8080:8080 \
    -v "/Users/macbookpro/IdeaProjects/servlet/target/servlet-1.0-SNAPSHOT.war:/usr/local/tomcat/webapps/servlet.war" \
    tomcat:9.0.53-jdk11-openjdk


docker build -t "servlet:latest" .

docker run --rm \
    --name custom-tomcat \
    --network demo_network \
    -p 8080:8080 \
    servlet:latest


docker run --rm \
    --name custom-tomcat \
    -e HELLO=WORLD \
    -p 8080:8080 \
    --network demo_network \
    servlet:latest

docker run --network demo_network --rm curlimages/curl:7.85.0 http://custom-tomcat:8080/servlet/test
docker run --rm curlimages/curl:7.85.0 http://localhost:8080/servlet/test


c



docker build -t "managed-tomcat" -f Dockerfile-tomcat-manager  .

docker run --rm \
    --name managed-tomcat \
    --network demo_network \
    -p 8080:8080 \
    -v "/Users/macbookpro/IdeaProjects/servlet/target/servlet-1.0-SNAPSHOT.war:/usr/local/tomcat/webapps/servlet.war" \
    managed-tomcat:latest

docker run --rm \
    --name demo-postgres \
    --network demo_network \
    -e POSTGRES_USER=postgres \
    -e POSTGRES_PASSWORD=postgres \
    -p 15432:5432 \
    -v "/Users/macbookpro/IdeaProjects/servlet/dev-env/postgres/init.sql:/docker-entrypoint-initdb.d/1-init.sql" \
    postgres:13.4-alpine
