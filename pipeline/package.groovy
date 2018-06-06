def run(String targetBranch, String configuration){  
    
    def type = 'packaging'
    def label = 'jenkins-nodejs'

    podTemplate(label: label) {
        node(label) {
            container('nodejs'){
                unstash 'workspace'
                try {
                    sh 'pipeline/package.sh'
                } catch (error) {
                    echo "FAILURE: ${type} failed"
                    echo error.message
                    throw error
                }
            }
        }
    }
}
return this;
