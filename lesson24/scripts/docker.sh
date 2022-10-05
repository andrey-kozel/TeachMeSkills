docker network create demo_network

#######################################
#Run tomcat with built project inside
#######################################

docker run --rm \
    --name tomcat \
    --network demo_network \
    -p 8080:8080 \
    -v "/Users/macbookpro/IdeaProjects/TeachMeSkills/lesson24/target/lesson24-1.0-SNAPSHOT.war:/usr/local/tomcat/webapps/servlet.war" \
    tomcat:9.0.53-jdk17-corretto

docker run --rm \
    --name demo-postgres \
    --network demo_network \
    -e POSTGRES_USER=postgres \
    -e POSTGRES_PASSWORD=postgres \
    -p 15432:5432 \
    -v "/Users/macbookpro/IdeaProjects/TeachMeSkills/lesson24/dev-env/postgres/init.sql:/docker-entrypoint-initdb.d/1-init.sql" \
    postgres:13.4-alpine
