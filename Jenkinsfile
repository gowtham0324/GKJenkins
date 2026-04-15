pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: https://github.com/gowtham0324/GKJenkins.git'
            }
        }

        stage('Build') {
            steps {
                echo 'Building project...'
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                sh 'mvn test'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying...'
            }
        }
    }
}
