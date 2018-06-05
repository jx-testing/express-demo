def run(String targetBranch, context){
    
    node() {
        checkout scm
        sh 'sleep 2000'
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

