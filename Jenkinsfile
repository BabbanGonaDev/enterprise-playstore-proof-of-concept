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
                // sh "ls"
                // sh "sudo chmod -R 777 ."
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
                // sh "echo sdk.dir=/var/dev/android >> local.properties"
                // // sh "ls"
                // // sh "sudo chmod -R 777 ."
                // sh "sudo /opt/gradle/gradle-7.6/bin/gradle wrapper"
                // sh "sudo ./gradlew bundle"
                // sh "sudo ./gradlew --stop"
                            }
        }

        stage ('archiving artifacts') {
            // when { branch 'develop' }
            steps {
                archiveArtifacts artifacts: 'app/build/outputs/bundle/release/*aab', followSymlinks: false, onlyIfSuccessful: true
 
                            }
        }

        // stage ('deploying to playstore') {
        //     // when { branch 'develop' }
        //     steps {
        //         echo 'Deploying the application to develop...'
        //         sh "./gradlew bundle"
        //                     }
        // }

        // stage ('Deploying in Prod Environment: production') {
        //     when { branch 'production'  }
        //     steps {
        //         echo 'Deploying the application to production...'
        //         sshPublisher(publishers: [sshPublisherDesc(configName: 'centos-wp', transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: ''' 
        //         GITUSER=$(cat gituser.txt)
        //         GITPASSWD=$(cat gittoken.txt)
		// USERPASSWD=$(cat password.txt)
        //         cd /var/www/html/collection_center_payment/
        //         pwd
        //         hostname
		// echo $USERPASSWD | sudo -S git pull https://$GITUSER:$GITPASSWD@github.com/BabbanGonaDev/collection_center_payment.git
		
        //         ''', execTimeout: 2000000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '.', remoteDirectorySDF: false, removePrefix: '', sourceFiles: '*.tar.gz')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: true)])        
        //     }
        // }
    }
}
  
