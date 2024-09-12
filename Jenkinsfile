pipeline {
    agent any
    tools {
        maven 'Maven 3.9' // Name must match the Maven installation name in Jenkins configuration
    }

    stages {
        stage('Cleanup') {
            steps {
                // Remove the directory if it exists
                bat 'rd /s /q Expense-Tracker || echo "Directory not found"'
            }
        }

        stage('Clone Repository') {
            steps {
                // Clone the repository into the build workspace
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
