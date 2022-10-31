./mvnw flyway:migrate -pl lesson30 -Dflyway.configFiles=src/main/resources/flyway.properties


./mvnw flyway:migrate -pl lesson30 -Dflyway.configFiles=src/main/resources/flyway2.properties

./mvnw flyway:migrate -pl lesson30 -Dflyway.configFiles=src/main/resources/flyway3.properties

cd lesson30
../mvnw flyway:migrate -pl lesson30 -Dflyway.configFiles=src/main/resources/flyway3.properties -f ../pom.xml
../mvnw flyway:migrate -pl lesson30 -Dflyway.configFiles=src/main/resources/flyway2.properties -f ../pom.xml
../mvnw flyway:migrate -pl lesson30 -Dflyway.configFiles=src/main/resources/flyway1.properties -f ../pom.xml
