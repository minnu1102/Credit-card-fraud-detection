pipeline {
    agent any

    environment {
        IMAGE_NAME = 'poorna730/credit-card-fraud-detection'
    }

    stages {
        stage('Clone Repo') {
            steps {
                git 'https://github.com/minnu1102/Credit-card-fraud-detection'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    dockerImage = docker.build("${IMAGE_NAME}")
                }
            }
        }

        stage('Push to Docker Hub') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', 'dockerhub-creds') {
                        dockerImage.push("latest")
                    }
                }
            }
        }

        stage('Clean Up') {
            steps {
                sh "docker rmi ${IMAGE_NAME}:latest || true"
            }
        }
    }
}
