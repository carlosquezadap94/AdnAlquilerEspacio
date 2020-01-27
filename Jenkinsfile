pipeline {
  //Donde se va a ejecutar el Pipeline
  agent {
    label 'Slave4'
  }

  //Opciones específicas de Pipeline dentro del Pipeline
  options {
    	buildDiscarder(logRotator(numToKeepStr: '3'))
		disableConcurrentBuilds()
  }

  //Una sección que define las herramientas “preinstaladas” en Jenkins
   tools {     
        jdk 'JDK8_Mac' 
    } 

  //Aquí comienzan los “items” del Pipeline
  stages{
     stage('Checkout'){ 
            steps{ 
                echo "------------>Checkout<------------" 
                checkout([$class: 'GitSCM',
				branches: [[name: '*/master']],
				doGenerateSubmoduleConfigurations: false,
				extensions: [],
				gitTool: 'Git_Centos',
				submoduleCfg: [],
				userRemoteConfigs: [[credentialsId: 'Github_carlosquezada',
				url:'https://github.com/carlosquezadap94/AdnAlquilerEspacio.git']]]) 
                sh 'chmod +x AdnAlquilerEspacio/gradlew'
            } 
        }     

     
        
		stage('Build aplication') { 
            steps{     
				echo "------------>Build aplication<------------" 
                dir ('AdnAlquilerEspacio/'){
                    sh './gradlew clean build'
                }
            } 
        }
		
		stage('Unit Tests aplication') { 
			steps{
				echo "------------>Unit Tests aplication<------------" 
				dir ('AdnAlquilerEspacio/'){
					sh './gradlew --b build.gradle test --scan'
				}
			}
		}
		
        stage('Static Code Analysis') {   
            steps{    
				echo "------------>Static Code Analysis<------------" 
                withSonarQubeEnv('Sonar'){
                    sh "${tool name: 'SonarScanner', type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner -Dproject.settings=sonar-project.properties"
                }       
            }     
        } 
  }

	post{ 
        always {  
            echo 'This will always run' 
        }     
        success {  
            echo 'This will run only if successful' 
            junit '**/test-results/test/*.xml'
        }  
        failure {   
            echo 'This will run only if failed'
            mail(to: 'carlos.quezada@ceiba.com.co',
                subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
                body: "Something is wrong with ${env.BUILD_URL}")
        }    
        unstable {      
            echo 'This will run only if the run was marked as unstable'    
        }     
        changed {      
            echo 'This will run only if the state of the Pipeline has changed'  
            echo 'For example, if the Pipeline was previously failing but is now successful'  
        } 
    }
}


