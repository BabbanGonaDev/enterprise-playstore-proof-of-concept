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
                sh "ls"
                sh "sudo chmod -R 777 ."
                sh "/opt/gradle/gradle-7.6/bin/gradle wrapper"
                sh "./gradlew bundle"
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
  