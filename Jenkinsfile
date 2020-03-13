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
        bat 'git \'https://github.com/foo/bar.git\''
        bat 'withSonarQubeEnv(credentialsId: \'f225455e-ea59-40fa-8af7-08176e86507a\', installationName: \'My SonarQube Server\') { // You can override the credential to be used       bat \'mvn sonar:sonar\'     }'
      }
    }

  }
  environment {
    my_test = '1'
  }
}