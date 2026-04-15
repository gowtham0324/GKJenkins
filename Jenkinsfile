pipeline {
    agent any

    // 🔧 Parameter (STANDARD NAME)
    parameters {
        string(name: 'SEARCH_ITEM', defaultValue: 'Iphone 16 Pro max', description: 'Search value')
    }

    environment {
        MAVEN_OPTS = "-Xmx1024m"
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/gowtham0324/GKJenkins.git'
            }
        }

        // 🔍 DEBUG STAGE (VERY IMPORTANT)
        stage('Debug Parameters') {
            steps {
                echo "Jenkins Parameter VALUE: ${params.SEARCH_ITEM}"

                sh """
                    echo "Shell VALUE: ${params.SEARCH_ITEM}"
                """
            }
        }

        stage('Run Tests') {
            steps {
                sh """
                    echo "Running Maven with searchItem=${params.SEARCH_ITEM}"
                    
                    mvn clean test -DsearchItem="${params.SEARCH_ITEM}"
                """
            }
        }
    }

    post {
        always {
            // 📊 Publish test results
            junit '**/target/surefire-reports/*.xml'

            // 📁 Archive artifacts
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
