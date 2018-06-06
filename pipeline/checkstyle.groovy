
def hanlderName = "checkstyle"

def runTest(String targetBranch, String configuration){  
    
    def label = 'jenkins-nodejs'

    podTemplate(label: label) {
        node(label) {
            container('nodejs'){
                unstash 'workspace'
                try {
                    sh 'pipeline/${hanlderName}.sh'
                } catch (error) {
                    echo "FAILURE: ${hanlderName} failed"
                    echo error.message
                    throw error
                }
            }
        }
    }
}

def name(){
    return hanlderName
}
return this;
