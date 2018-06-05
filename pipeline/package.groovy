def runTest(String targetBranch, context){
    
    node() {
        checkout scm
        try {
                sh 'pipeline/package.sh'
                
        } catch (error) {
            echo "FAILURE: packaging failed"
            echo error.message
            throw error
        }
    }
}
return this;

