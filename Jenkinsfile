node {
    stage('Checkout') {
        steps {
            checkout scm
        }
    }
    stage('Clean') {
        steps {
            withMaven(maven : 'maven_3.5.4'){
              bat 'mvn clean'
            }
        }
    }
    stage('Compile') { 
        steps {
            withMaven(maven : 'maven_3.5.4'){
              bat 'mvn compile'
            }
        }
    }
    stage('Install') { 
        steps {
            withMaven(maven : 'maven_3.5.4'){
              bat 'mvn install'
            }
        }
    }
}
