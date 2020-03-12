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
        slackSend(channel: '#jenkins', message: 'A pipeline went through', username: 'Jenkins', attachments: 'null', blocks: 'null')
      }
    }

  }
  environment {
    my_test = '1'
  }
}