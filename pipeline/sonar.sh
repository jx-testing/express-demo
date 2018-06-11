#!/bin/bash
echo "This is sonar.sh"

npm i sonar-scanner && chown -R 10000:10000 node_modules

echo 'sonar.host.url=http://sonarqube-sonarqube:9000' > sonar-scanner.properties
echo 'sonar.projectKey=dandevops:nodejs-hello' >> sonar-project.properties
echo 'sonar.projectName=NodeJS Hello World' >> sonar-project.properties
echo 'sonar.projectVersion=1.0' >> sonar-project.properties
echo 'sonar.sources=.' >> sonar-project.properties 
./node_modules/sonar-scanner/bin/sonar-scanner -X -Dsonar.login=admin -Dsonar.password=admin -Dsonar.host.url=http://democluster-team1-sonarqube-sonarqube.democluster-team1.svc.cluster.local:9000


