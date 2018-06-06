def runTest(String targetBranch, String configuration){
    
    node() {
        checkout scm
        try {
                sh 'pipeline/integration.sh'
                
        } catch (error) {
            echo "FAILURE: Integration Tests failed"
            echo error.message
            throw error
        }
    }
}
return this;
