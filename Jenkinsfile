pipeline {
  agent any
  stages {
    stage('builder') {
      steps {
        sh 'npm install'
      }
    }

  }
  environment {
    my_test = '1'
  }
}