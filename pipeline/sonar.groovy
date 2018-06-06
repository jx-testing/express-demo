
def runTest(String targetBranch, String configuration){  
    
    def label = 'jenkins-nodejs'

    podTemplate(label: label) {
        node(label) {
            def name = 'sonar'
            container('nodejs'){
                unstash 'workspace'
                try {
                    sh 'pipeline/${name}.sh'
                } catch (error) {
                    echo "FAILURE: ${name} failed"
                    echo error.message
                    throw error
                }
            }
        }
    }
}

def getName(){
    return "sonar"
}

return this;