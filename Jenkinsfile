pipeline {
    agent { label 'maven' }

    tools {
        // This MUST match the 'Name' you gave it in the Global Tools section
        allure 'Allure 2.30'
    }

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
                sh "mvn clean test || true"
            }
        }

        stage('Allure Report Publisher') {
            steps {
                echo "Publishing Allure results..."
                allure([
                    includeProperties: false,
                    jdk: '',
                    properties: [],
                    reportBuildPolicy: 'ALWAYS',
                    // CHANGE THIS: Since this is the direct test job,
                    // Maven puts results in target/allure-results
                    results: [[path: 'target/allure-results']]
                ])
            }
        }
    }

    post {
        always {
            // Archive the actual results produced by Maven
            archiveArtifacts artifacts: 'target/allure-results/**', allowEmptyArchive: true
        }
    }
}