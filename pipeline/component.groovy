def runTest(String targetBranch, String configuration){
    
    node() {
        checkout scm
        try {
                sh 'pipeline/component.sh'
                
        } catch (error) {
            echo "FAILURE: Component Tests failed"
            echo error.message
            throw error
        }
    }
}
return this;
