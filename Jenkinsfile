pipeline {
  agent any
  stages {
    stage('builder') {
      steps {
        echo 'simple pipeline'
      }
    }

    stage('sonar') {
      steps {
        sh '''node {
  stage(\'SCM\') {
    git \'https://github.com/boxf/SpringJpa.git\'
  }
  stage(\'SonarQube analysis\') {
    withSonarQubeEnv(installationName: \'Sonar_SpringJpa\') { // You can override the credential to be used
      bat \'mvn sonar:sonar\'
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