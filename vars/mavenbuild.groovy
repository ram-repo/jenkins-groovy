def call() {
    pipeline {
        agent {
            label 'build-agent'
        }
        stages {
            stage('Build') {
                steps {
                    sh "mvn clean package"
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
