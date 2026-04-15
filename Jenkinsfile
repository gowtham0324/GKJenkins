pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    parameters {
        string(name: 'SEARCH_ITEM', defaultValue: 'Iphone 17Pro max', description: 'Search value')
    }

    triggers {
        // Runs daily at 9 AM IST (3:30 AM UTC)
        cron('30 3 * * *')

        // Trigger on SCM polling (detects push to main branch)
        pollSCM('H/5 * * * *')
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
            junit '**/target/surefire-reports/*.xml'

            publishHTML([
                reportDir             : 'target/surefire-reports',
                reportFiles           : 'index.html',
                reportName            : 'Test Report',
                keepAll               : true,
                allowMissing          : true,
                alwaysLinkToLastBuild : true
            ])

            archiveArtifacts artifacts: '**/target/**/*.*', allowEmptyArchive: true
        }
    }
}
