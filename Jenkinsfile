pipeline {
    agent { label 'maven' }

    tools {
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

                sh "mvn clean test -Dmaven.test.failure.ignore=true"
            }
        }
    }

    post {
        always {
            echo "Publishing Allure results..."
            archiveArtifacts artifacts: '**/allure-results/**', allowEmptyArchive: true

            allure([
                includeProperties: false,
                jdk: '',
                properties: [],
                reportBuildPolicy: 'ALWAYS',
                results: [[path: 'target/allure-results'], [path: 'allure-results']]
            ])
        }
    }
}