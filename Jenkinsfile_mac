pipeline {
    // master executor should be set to 0
    agent any
    stages {
        stage('Build Jar') {
            steps {
                //bat for windows
                sh "mvn clean package -DskipTests"
            }
        }
        stage('Build Image') {
            steps {
                //bat for windows
                sh "docker build -t='sritaj/selenium-docker' ."
            }
        }
        stage('Push Image') {
            steps {
			    withCredentials([usernamePassword(credentialsId: 'sritajpatel', passwordVariable: 'jenkins', usernameVariable: 'sritajpatel')]) {
			        sh "docker login --username=${user} --password=${pass}"
			        sh "docker push sritaj/selenium-docker:latest"
			    }
            }
        }
    }
}