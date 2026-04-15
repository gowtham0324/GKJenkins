pipeline {
    agent any

    tools {
        maven 'Maven'
    }

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
                echo "Running with SEARCH_ITEM=${params.SEARCH_ITEM}"

                bat "mvn clean test -DsearchItem=\"${params.SEARCH_ITEM}\""
            }
        }
    }

    post {
        always {
            // JUnit test results
            junit '**/target/surefire-reports/*.xml'

            // HTML Report publish
            publishHTML([
                reportDir   : 'target/surefire-reports',
                reportFiles : 'index.html',
                reportName  : 'Test Report',
                keepAll     : true,
                allowMissing: false
            ])

            // Archive artifacts
            archiveArtifacts artifacts: '**/target/**/*.*', allowEmptyArchive: true
        }
    }
}
