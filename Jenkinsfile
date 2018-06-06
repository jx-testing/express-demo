#!/bin/groovy

@Library('pipeline-lib')
import com.stack1.plib.*

def configuration = "config.json"

def     unitTester = ['pipeline/stub.groovy']
def     staticAnalyser =  [ 'pipeline/stub.groovy', 'pipeline/stub.groovy']
def 	packager = 'pipeline/package.groovy'
def 	deployer = 'pipeline/deploy.groovy'
def     componentTester = [ 'pipeline/stub.groovy' ]
def     integrationTester = [ 'pipeline/stub.groovy' ]

Handlers handlers = new Handlers(packager, deployer, unitTester, staticAnalyser, componentTester, integrationTester) as Handlers

invokePipeline( 'express-demo', handlers, configuration )


