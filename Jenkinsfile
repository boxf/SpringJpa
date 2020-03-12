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
      }
    }

  }
  environment {
    my_test = '1'
  }
}