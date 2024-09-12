pipeline {
    agent any

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
                // Change directory to the cloned repository and build
                dir('Expense-Tracker') {
                    bat 'mvn clean install'
                }
            }
        }
    }
}
