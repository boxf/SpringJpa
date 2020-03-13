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
      parallel {
        stage('sonar') {
          steps {
            bat 'git \'https://github.com/foo/bar.git\''
          }
        }

        stage('SonarQube analysis') {
          steps {
            bat 'withSonarQubeEnv(credentialsId: \'f225455e-ea59-40fa-8af7-08176e86507a\', installationName: \'My SonarQube Server\') {   bat \'mvn sonar:sonar\'     }'
          }
        }

      }
    }

  }
  environment {
    my_test = '1'
  }
}