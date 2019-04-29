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
                sh './gradlew clean classes'
            }
        }
        stage('micro test') {
            steps {
                sh './gradlew test'
            }
        }
        stage('build artifact') {
            steps {
                sh './gradlew shadowJar'
            }
        }
        stage('deploy') {
            parallel {
                stage('publish') {
                    steps {
                        sh "./gradlew publish -Pversion=${artifactVersion}"
                    }
                }
                stage('docker') {
                    stages {
                        stage('create image') {
                            steps {
                                sh "./gradlew -Pversion=${artifactVersion} docker dockerTag dockerTagLatest"
                            }
                        }
                        stage('deploy') {
                            steps {
                                sh """
                                    \$(aws ecr get-login --no-include-email --profile nodal) && \
                                    ./gradlew -Pversion=${artifactVersion} dockerPush dockerPushLatest && \
                                    docker image prune -f
                                """
                            }
                        }
                    }
                }

            }
        }
        stage('tag git') {
            steps {
                sh "git tag -f release/${artifactVersion} && git push origin --tags --force"
            }
        }
    }

    post {
        success {
            wrap([$class: 'BuildUser']) {
                script {
                    commitMessage = sh(returnStdout: true, script: "git log -n 1 --pretty=format:'%an - %s'").trim()
                }
                slackSend(color: '#00FF00', message: ":smile: <${env.RUN_DISPLAY_URL}|${env.JOB_NAME} [${env.BUILD_NUMBER}]> [$commitMessage] by ${BUILD_USER_FIRST_NAME}")
            }
        }
        failure {
            wrap([$class: 'BuildUser']) {
                script {
                    commitMessage = sh(returnStdout: true, script: "git log -n 1 --pretty=format:'%an - %s'").trim()
                }
                slackSend(color: '#FF0000', message: ":japanese_ogre: <${env.RUN_DISPLAY_URL}|${env.JOB_NAME} [${env.BUILD_NUMBER}]> [$commitMessage] by ${BUILD_USER_FIRST_NAME}")
            }
        }
        aborted {
            wrap([$class: 'BuildUser']) {
                script {
                    commitMessage = sh(returnStdout: true, script: "git log -n 1 --pretty=format:'%an - %s'").trim()
                }
                slackSend(color: '#000000', message: ":poop: <${env.RUN_DISPLAY_URL}|${env.JOB_NAME} [${env.BUILD_NUMBER}]> [$commitMessage] by ${BUILD_USER_FIRST_NAME}")
            }
        }
        always {
            junit "build/test-results/**/*.xml"
        }
    }
}

