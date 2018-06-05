def runTest(String targetBranch, context){  
    
    def label = 'jenkins-nodejs'
    podTemplate(label: label) {
        node(label) {
            container('nodejs'){
                checkout scm
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