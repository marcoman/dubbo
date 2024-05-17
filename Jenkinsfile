pipeline {
    agent any
        tools {
            maven 'maven 3.9.6'
            jdk 'java-17-corretto'
        }

   stages {
        stage('Start') {
            steps {
                echo 'welcome to the build'
                sh 'whoami'
                sh 'ls ~/'
                sh 'ls ~/.ssh'
            }
        }
        stage('Checkout') {
            steps {
                echo 'checkout'
                step([$class: 'WsCleanup'])
                git branch: 'develocity-1',
                    credentialsId: 'github',
                    changelog: true,
                    url: 'git@github.com:marcoman/dubbo.git'
            }
        }
        stage('Build') {
            steps {
                echo './mvnw clean validate'
                sh './mvnw clean validate'
            }
        }
    }
}