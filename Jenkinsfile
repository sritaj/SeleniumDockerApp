pipeline {
  agent any 
  // Specifying the environments configured under Jenkins Global Configuration/Keys
  environment {
        registryCredential = 'dockerHub'
  }
  
  stages {
    // Creating the JAR files
    stage('Build') {
      steps {
        sh 'mvn clean package -DskipTests'
      }
    }
    // Creating the Docker Image
    stage('Build Docker Image') {
      steps {
        // "docker build -t sritaj/selenium_docker:latest ."
        script {
          docker.build("sritaj/selenium_docker")
        }
        
      }
    }
    // Pushing the Docker Image
    stage('Push Docker Image') {
      steps {
        script{
          docker.withRegistry('', registryCredential){
            dockerImage.push("${BUILD_NUMBER}")
            dockerImage.push('latest')
          }
        }
      }     
      // steps{
      //   withCredentials([usernamePassword(credentialsId: 'dockerHub', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
      //     sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPassword}"
      //     sh 'docker push sritaj/selenium_docker:latest'
      //   }
      // }  
    }
  }
}