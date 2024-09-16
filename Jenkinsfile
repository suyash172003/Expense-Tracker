pipeline {
    agent any
    tools {
        maven 'Maven 3.9' // Name must match the Maven installation name in Jenkins configuration
    }

    stages {
        stage('Cleanup') {
            steps {
                script {
                    def dirPath = 'C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\Expense Tracker\\Expense-Tracker'
                    def command = "if exist \"${dirPath}\" (rd /s /q \"${dirPath}\") else (echo \"Directory not found\")"
                    bat command
                }
            }
        }

        stage('Clone Repository') {
            steps {
                bat 'git clone https://github.com/suyash172003/Expense-Tracker.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }
    }
}
