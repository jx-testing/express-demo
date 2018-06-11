#!/bin/bash
echo "This is sonar.sh"

npm i sonar-scanner

echo 'sonar.host.url=http://sonarqube-sonarqube:9000' > sonar-scanner.properties
echo 'sonar.projectKey=dandevops:nodejs-hello' >> sonar-project.properties
echo 'sonar.projectName=NodeJS Hello World' >> sonar-project.properties
echo 'sonar.projectVersion=1.0' >> sonar-project.properties
echo 'sonar.sources=.' >> sonar-project.properties 
./node_modules/sonar-scanner/bin/sonar-scanner -Dsonar.login=admin -Dsonar.password=admin


