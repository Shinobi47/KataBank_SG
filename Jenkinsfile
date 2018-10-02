pipeline {
    agent any 
    stages {
        stage('Clean') { 
            steps 
                withMaven(maven : maven_3.5.4){
                  sh 'mvn clean'
                }
            }
        }
        stage('Compile') { 
            steps 
                withMaven(maven : maven_3.5.4){
                  sh 'mvn compile'
                }
            }
        }
        stage('Install') { 
            steps 
                withMaven(maven : maven_3.5.4){
                  sh 'mvn install'
                }
            }
        }
    }
}
