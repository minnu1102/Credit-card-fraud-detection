pipeline {
    agent any

    environment {
        DOCKER_HUB_CREDS = credentials('dockerhub-credentials') // Jenkins credentials ID
        IMAGE_NAME = 'credit-card-fraud-detection'
        IMAGE_TAG = 'latest'
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from the GitHub repository
                git 'https://github.com/minnu1102/Credit-card-fraud-detection.git'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    // Build the Docker image
                    sh 'docker build -t $IMAGE_NAME:$IMAGE_TAG .'
                }
            }
        }

        stage('Login to Docker Hub') {
            steps {
                script {
                    // Log in to Docker Hub using Jenkins credentials
                    withDockerRegistry([credentialsId: 'dockerhub-credentials', url: 'https://index.docker.io/v1/']) {
                        sh 'docker login -u $DOCKER_HUB_CREDS_USR -p $DOCKER_HUB_CREDS_PSW'
                    }
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    // Tag and push the image to Docker Hub
                    sh 'docker tag $IMAGE_NAME:$IMAGE_TAG poorna730/$IMAGE_NAME:$IMAGE_TAG'
                    sh 'docker push poorna730/$IMAGE_NAME:$IMAGE_TAG'
                }
            }
        }

        stage('Cleanup') {
            steps {
                // Clean up to remove old images
                sh 'docker rmi $IMAGE_NAME:$IMAGE_TAG || true'
            }
        }
    }

    post {
        always {
            // Always run clean up tasks, if any
            cleanWs()
        }
    }
}
