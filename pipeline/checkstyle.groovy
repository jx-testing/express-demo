
String name = "Checkstyle scan"

def runTest(String targetBranch, String configuration){  
    
    def type = 'Static analysis'
    def label = 'jenkins-nodejs'

    podTemplate(label: label) {
        node(label) {
            container('nodejs'){
                unstash 'workspace'
                try {
                    sh 'pipeline/checkstyle.sh'
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
    return name
}
return this;
