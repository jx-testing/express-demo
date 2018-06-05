def runTest(String targetBranch, context){  
    
    def label = 'java'
    podTemplate(label: label) {
        node(label) {
            checkout scm
            try {
                sh 'pipeline/sonar.sh'
            } catch (error) {
                echo "FAILURE: SA Tests failed"
                echo error.message
                throw error
            }
        }
    }
}
return this;
