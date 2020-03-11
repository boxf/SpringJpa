pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        build 'Builder'
      }
    }

    stage('deploy') {
      steps {
        echo 'Done'
      }
    }

  }
  environment {
    my_test = '1'
  }
}