pipeline {
    agent any

    

    stages {
        
        // stage('Code Quality Check via SonarQube') {
        //   steps{
        //   script{ 
        //   def scannerHome = tool 'sonarqube-scanner';
        //   withSonarQubeEnv("babbangona-dev") {
        //       sh "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=collection-center-payment -Dsonar.sources=. -Dsonar.css.node=. -Dsonar.host.url=http://localhost:9000/ -Dsonar.login=80a14365591bacdb6a2ddf5b5096ba78547f886e -Dsonar.javascript.lcov.reportPaths=coverage/lcov.info"
        //       }
		   
        //      }
        //   }
        // }
//         stage('Unit Test'){

//           steps{
//               sh "cd unittest"
//                }
		   
//              }

        stage (' building app') {
            // when { branch 'develop' }
            steps {
                sh "echo Deploying the application to develop..."
                sh "echo sdk.dir=/var/dev/android >> local.properties"
                sh "sudo /opt/gradle/gradle-7.6/bin/gradle wrapper"
                sh "sudo ./gradlew bundle"
                sh "sudo ./gradlew --stop"
                            }
        }


        stage ('signing the app') {
            // when { branch 'develop' }
            steps {
                withCredentials([file(credentialsId: 'playstore.jks', variable: 'FILE')]) {
                    sh 'sudo jarsigner -verbose -sigalg SHA256withRSA -digestalg SHA-256 -keystore $FILE app/build/outputs/bundle/release/app-release.aab key0 -storepass "QwU3.p^p"'
                }
                            }
        }

        stage ('deploying to playstore') {
            // when { branch 'develop' }
            steps {
               androidApkUpload filesPattern: '**/build/outputs/**/*release.aab', googleCredentialsId: 'Playstore api access', rolloutPercentage: '100', trackName: 'production'
 
                            }
        }

        stage ('archiving artifacts') {
            // when { branch 'develop' }
            steps {
                archiveArtifacts artifacts: 'app/build/outputs/bundle/release/*aab', followSymlinks: false, onlyIfSuccessful: true
 
                            }
        }

    }
}
  
