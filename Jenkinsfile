pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    parameters {
        string(name: 'SEARCH_ITEM', defaultValue: 'Iphone 17Pro max', description: 'Search value')
    }

    triggers {
        cron('30 3 * * *')   // 9 AM IST daily schedule only
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

        stage('Generate Allure Report') {
            steps {
                bat "mvn allure:report"
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'

            allure([
                includeProperties: false,
                jdk              : '',
                results          : [[path: 'target/allure-results']]
            ])
        }
    }
}
