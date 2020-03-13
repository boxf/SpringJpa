pipeline {
  agent any
  stages {
    stage('builder') {
      steps {
        echo 'simple pipeline'
      }
    }

    stage('slack') {
      steps {
        sh '''node {
  stage(\'SCM\') {
    git \'https://github.com/CedricP-Git/SpringJPA.git\'
  }
  stage(\'SonarQube analysis\') {
    withSonarQubeEnv(installationName: \'Sonar_SpringJpaMy\') { // You can override the credential to be used
      sh \'mvn sonar:sonar\'
    }
  }
}'''
        }
      }

    }
    environment {
      my_test = '1'
    }
  }