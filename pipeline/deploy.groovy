def run(String targetBranch, String configuration){
    
    node() {
        checkout scm
        try {
                sh 'pipeline/deploy.sh'
                
        } catch (error) {
            echo "FAILURE: Deploy failed"
            echo error.message
            throw error
        }
    }
}
return this;

