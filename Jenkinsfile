#!/bin/groovy

@Library('pipeline-lib')
import com.stack1.plib.*

/*
node('jenkins-nodejs'){
		container('nodejs'){
		echo "PAUSING"	
		sh 'kubectl get pods'
	}
}
*/


def configuration = "config.json"

def 	packager = 'pipeline/package.groovy'
def 	deployer = 'pipeline/deploy.groovy'
def     unitTester = ['pipeline/unit.groovy']
def     staticAnalyser =  [ 'pipeline/sonar.groovy' ]
def     componentTester = [ 'pipeline/component.groovy' ]
def     integrationTester = [ 'pipeline/integration.groovy' ]

Handlers handlers = new Handlers(packager, deployer, unitTester, staticAnalyser, componentTester, integrationTester) as Handlers

invokePipeline( 'python-http', handlers, configuration )


