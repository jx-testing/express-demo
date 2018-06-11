#!/bin/bash
echo "This is sonar.sh"

npm i sonar-scanner && chown -R 10000:10000 node_modules

echo 'sonar.host.url=http://democluster-team1-sonarqube-sonarqube.democluster-team1.svc.cluster.local:9000' > sonar-scanner.properties
echo 'sonar.projectKey=dandevops:demo' >> sonar-project.properties
echo 'sonar.projectName=demo' >> sonar-project.properties
echo 'sonar.projectVersion=1.0' >> sonar-project.properties
echo 'sonar.sources=examples' >> sonar-project.properties 

./node_modules/sonar-scanner/bin/sonar-scanner -X -Dsonar.login=admin -Dsonar.password=admin 

chown -R 10000:10000 .scannerwork


