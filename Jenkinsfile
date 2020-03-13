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
        slackSend(channel: '#jenkins', message: 'A pipeline went through', attachments: 'fallback', color: '#910A60', blocks: 'section')
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