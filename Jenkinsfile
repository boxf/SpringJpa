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
        slackUserIdFromEmail 'cedric.f.pellegirni@gmail.com'
        slackSend(baseUrl: 'https://app.slack.com/client/TVCD97FB9/CVB4NN205', channel: '#jenkins', message: 'A pipeline went through')
      }
    }

  }
  environment {
    my_test = '1'
  }
}