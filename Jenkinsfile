pipeline {
  agent any
  stages {
    stage('builder') {
      steps {
        echo 'simple pipeline'
      }
    }

    stage('sonnar') {
      steps {
        waitForQualityGate true
      }
    }

  }
  environment {
    my_test = '1'
  }
}