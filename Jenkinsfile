pipeline {
    agent any

    environment {
        APP_NAME = 'springboot-app'
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Récupération du code...'
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                echo 'Compilation + Tests avec Maven'
                sh 'mvn clean verify'
            }
            post {
                always {
                    junit testResults: 'target/surefire-reports/*.xml', allowEmptyResults: true
                }
            }
        }

        stage('Package JAR') {
            steps {
                echo 'Génération du JAR executable'
                sh 'mvn package -DskipTests'
            }
            post {
                success {
                    archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
                }
            }
        }
    }

    post {
        always {
            cleanWs()
        }
        success {
            echo 'Build Spring Boot terminé avec succès !'
        }
        failure {
            echo 'Échec du build'
        }
    }
}

