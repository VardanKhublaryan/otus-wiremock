pipeline {
    agent { label 'maven' }

    stages {
        stage('Test Allure CLI') {
            steps {
                sh "allure --version"
            }
        }

        stage('Checkout') {
            steps {
                checkout([$class: 'GitSCM',
                          branches: [[name: 'master']],
                          userRemoteConfigs: [[url: 'https://github.com/VardanKhublaryan/otus-wiremock.git']]
                ])
            }
        }

        stage('Run Tests') {
            steps {
                // Run tests but do not fail the pipeline if there are test errors
                sh """
                mvn clean test
                """
            }
        }

        stage('Allure Report Publisher') {
            steps {
                echo "Publishing Allure results..."
                // Allure stage will always run even if tests had errors
                allure([
                    includeProperties: false,
                    jdk: '',
                    properties: [],
                    reportBuildPolicy: 'ALWAYS',
                    results: [[path: 'allure-results']]
                ])
            }
        }
    }

    post {
        always {
            echo "Pipeline finished"
        }
    }
}