pipeline {
    agent any

    parameters {
        string(name: 'SEARCH_ITEM', defaultValue: 'Iphone 17Pro max', description: 'Search value')
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/gowtham0324/GKJenkins.git'
            }
        }

        stage('Run Tests') {
            steps {
                sh "mvn clean test -DsearchItem='${params.SEARCH_ITEM}'"
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
            archiveArtifacts artifacts: '**/target/**/*.*', allowEmptyArchive: true
        }

        success {
            echo "✅ Build Successful"
        }

        failure {
            echo "❌ Build Failed"
        }
    }
}
