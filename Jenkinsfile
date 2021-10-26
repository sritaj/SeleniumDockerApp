pipeline {
  agent none
  stages {
    stage('Maven Install and JAR Builds') {
      agent {
        docker {
          image 'maven:3.8.3-openjdk-8-slim'
        }
      }
      steps {
        sh 'mvn clean package -DskipTests'
      }
    }
    stage('Docker Build') {
      agent any
      steps {
        sh 'docker build -t sritaj/selenium_docker:latest .'
      }
    }
    stage('Docker Push') {
      agent any
      steps {
        withCredentials([usernamePassword(credentialsId: 'dockerHub', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
          sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPassword}"
          sh 'docker push sritaj/selenium_docker:latest'
        }
      }
    }
  }
}