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
        bat(script: 'git \'https://github.com/boxf/SpringJpa.git\'   }   stage(\'SonarQube analysis\') {     withSonarQubeEnv(installationName: \'My SonarQube Server\') {        bat \'mvn sonar:sonar\'     }', returnStdout: true)
      }
    }

  }
  environment {
    my_test = '1'
  }
}