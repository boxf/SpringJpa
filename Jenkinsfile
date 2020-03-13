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
        git 'https://github.com/boxf/SpringJpa.git'
        withSonarQubeEnv('My sonarQuebe Server') {
          bat 'mvn sonar:sonar'
        }

      }
    }

  }
  environment {
    my_test = '1'
  }
}