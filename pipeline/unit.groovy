def runTest(String targetBranch, String configuration){  
    
    def label = 'jenkins-nodejs'
    podTemplate(label: label) {
        node(label) {
            container('nodejs'){
                checkout scm
                //sh 'sleep 10000'
                try {
                    sh 'pipeline/unit.sh'
                } catch (error) {
                    echo "FAILURE: Unit Tests failed"
                    echo error.message
                    throw error
                }
            }
        }
    }
}
return this;
