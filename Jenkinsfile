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
        slackUserIdFromEmail(email: 'cedric.f.pellegirni@gmail.com', botUser: true)
        slackSend(channel: '#jenkins', message: 'A pipeline went through', username: 'Jenkins', attachments: 'JSONArray')
      }
    }

  }
  environment {
    my_test = '1'
  }
}