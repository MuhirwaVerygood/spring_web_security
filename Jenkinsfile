pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    stages {
        stage("Build") {
            steps {
                echo 'Building the application...'
                sh 'mvn clean package'
            }
        }

        stage("Test") {
            steps {
                echo 'Testing the application...'
                sh 'mvn test'
            }
        }

        stage("Build Docker Image") {
            steps {
                echo 'Building Docker image...'
                sh 'docker build -t library-management-app:1.0 .'
            }
        }

        stage("Deploy") {
            steps {
                echo 'Deploying the application.. yes.'
                sh 'docker run -d -p 3600:3600 --name library-management-app library-management-app:1.0'
            }
        }
    }

    post {
        always {
            echo 'Cleaning up...'
            sh 'docker system prune -f'
        }
        success {
            echo 'Pipeline completed successfully.'
        }
        failure {
            echo 'Pipeline failed.'
        }
    }
}
