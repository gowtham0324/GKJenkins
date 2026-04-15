pipeline {
    agent any

    parameters {
        string(name: 'SearchItem', defaultValue: 'laptop', description: 'Search value')
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/gowtham0324/GKJenkins.git'
            }
        }

        stage('Run Tests') {
            steps {
                sh "mvn clean test -DsearchItem=${params.SearchItem}"
            }
        }
    }
}
