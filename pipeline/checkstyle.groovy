
def runTest(String targetBranch, String configuration){  
    
    def foo = 'checkstyle'
    def label = 'jenkins-nodejs'

    podTemplate(label: label) {
        node(label) {
            container('nodejs'){
                unstash 'workspace'
                try {
                    sh 'pipeline/${foo}.sh'
                } catch (error) {
                    echo "FAILURE: ${foo} failed"
                    echo error.message
                    throw error
                }
            }
        }
    }
}

def getName(){
    return "checkstyle"
}

return this;