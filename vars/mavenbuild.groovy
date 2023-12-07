def call() {
    pipeline {
        agent {
            label 'build-agent'
        }
        stages {
            stage('Build') {
                steps {
                    script {
                        com.example.Utils.buildStage()
                    }
                }

                post {
                    success {
                        junit '**/target/surefire-reports/*.xml'
                        archiveArtifacts 'target/*.jar'
                    }
                }
            }
        }
    }
}
