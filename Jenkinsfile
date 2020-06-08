pipeline {
    agent any
    tools {
        maven 'maven_3.6.3' 
    }
    stages 
    {
        stage('build') {
            
            	steps{
            			bat 'mvn -f ConsumerService/pom.xml -DskipTests=true clean package '

            		}
            }
            
         stage('deploy')
         {
         		steps{
         				withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'PCF_LOGIN',
						usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']]) 
						{

							bat 'cf login -a https://api.run.pivotal.io -u gomathyuc29@gmail.com -p Abhi29@lash'
							bat 'cf target -s ascend-test-space'
							bat 'cf push -f ConsumerService/manifest.yml'
 						}
         
         			}
         	
         }
     }
}