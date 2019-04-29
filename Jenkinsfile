#!groovy
pipeline {
    agent any

    environment {
        commitMessage = ""
        artifactVersion = "1.0.${env.BUILD_NUMBER}"
    }

    stages {
        stage('compile') {
            steps {
                sh "./gradlew clean classes"
            }
        }
        stage('micro test') {
            steps {
                sh "./gradlew test"
            }
        }
        stage('build artifact') {
            steps {
                sh "./gradlew shadowJar -Pversion=${artifactVersion}"
            }
        }
        stage('deploy') {
            steps {
                sh "./gradlew publish -Pversion=${artifactVersion}"
            }
        }
        stage('tag git') {
            steps {
                sh "git tag -f release/${artifactVersion} && git push origin --tags --force"
            }
        }
    }

    post {
        always {
            junit "build/test-results/**/*.xml"
        }
    }
}

