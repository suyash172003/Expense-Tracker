pipeline{
    agent any;
    environment  {
        BUILD_IMAGE_TAG = "${BUILD_NUMBER}"
    }
    stages{
        stage("Checkout"){
            steps {
                sh '''
                sudo usermod -aG docker jenkins
                sudo chmod 777 /var/run/docker.sock
                sudo ls -l /var/run/docker.sock
                '''
            }
        }
        stage("Build"){
            steps {
                sh '''
                mvn clean
                mvn install
                '''
            }
        }

        stage("Build Docker Image and push"){
            steps {
               sh '''
                docker build -t suyash172003/expense-tracker:v.0.${BUILD_IMAGE_TAG}
                docker push suyash172003/expense-tracker:v.0.${BUILD_IMAGE_TAG}
               '''
            }
        }
    }
}