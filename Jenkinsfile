pipeline {
  agent any
  stages {
    stage('builder') {
      steps {
        echo 'simple pipeline'
      }
    }

    stage('sonar') {
      steps {
        sh '''try {
stage("Building SONAR ...") {
sh \'./gradlew clean sonarqube\'
}
} catch (e) {emailext attachLog: true, body: \'See attached log\', subject: \'BUSINESS Build Failure\', to: \'cedric.f.pellegrini@gmail.com\'
step([$class: \'WsCleanup\'])
return
}'''
        }
      }

    }
    environment {
      my_test = '1'
    }
  }