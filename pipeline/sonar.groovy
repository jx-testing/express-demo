def runTest(String targetBranch, String configuration){  
    
    def type = 'Static analysis'
    def label = 'jenkins-nodejs'

    podTemplate(label: label) {
        node(label) {
            container('nodejs'){
                unstash 'workspace'
                try {
                    sh 'pipeline/sonar.sh'
                } catch (error) {
                    echo "FAILURE: ${type} failed"
                    echo error.message
                    throw error
                }
            }
        }
    }
}

def name(){
    return "Sonari scan"
}
return this;