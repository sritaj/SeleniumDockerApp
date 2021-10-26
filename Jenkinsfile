pipeline {
  agent {
        docker {
            image 'maven:3-alpine' 
            args '-v /root/.m2:/root/.m2' 
        }
  }
  stages {
    stage('Build') {
      steps {
        sh 'mvn clean package -DskipTests'
      }
    }
    // stage('Docker Build') {
    //   agent any
    //   steps {
    //     sh 'docker build -t sritaj/selenium_docker:latest .'
    //   }
    // }
    // stage('Docker Push') {
    //   agent any
    //   steps {
    //     withCredentials([usernamePassword(credentialsId: 'dockerHub', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
    //       sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPassword}"
    //       sh 'docker push sritaj/selenium_docker:latest'
    //     }
    //   }
    // }
  }
}