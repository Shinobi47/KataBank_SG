node {
    stage('Checkout') {
		checkout scm
    }
    stage('Clean') {
		withMaven(maven : 'maven_3.5.4'){
            bat 'mvn clean'
        }
    }
    stage('Compile') { 
        withMaven(maven : 'maven_3.5.4'){
          bat 'mvn compile'
        }
    }
    stage('Install') {
        withMaven(maven : 'maven_3.5.4'){
          bat 'mvn install'
        }
    }
}
