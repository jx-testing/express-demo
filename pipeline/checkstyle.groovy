
String name = "checkstyle"

def runTest(String targetBranch, String configuration){  
    
    def label = 'jenkins-nodejs'

    podTemplate(label: label) {
        node(label) {
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

def name(){
    return name
}
return this;
