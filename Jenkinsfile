pipeline {
  agent any
  stages {
    stage('builder') {
      steps {
        echo 'simple pipeline'
        bat 'echo "test"'
      }
    }

    stage('sonar') {
      steps {
        withSonarQubeEnv('Sonar_TravelNShare') {
          sh 'mvn sonar:sonar'
        }

      }
    }

  }
  environment {
    my_test = '1'
  }
}