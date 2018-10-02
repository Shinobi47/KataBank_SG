pipeline {
    agent any 
    stages {
        stage('Clean') {
            try{
				steps {
					withMaven(maven : 'maven_3.5.4'){
					sh 'mvn clean'
					}
				}
			} catch (err) {
				error('CLEAN STAGE FAILS')
				throw err
			}
        }
        stage('Compile') { 
            steps {
                withMaven(maven : 'maven_3.5.4'){
                  sh 'mvn compile'
                }
            }
        }
        stage('Install') { 
            steps {
                withMaven(maven : 'maven_3.5.4'){
                  sh 'mvn install'
                }
            }
        }
    }
}
