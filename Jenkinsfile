pipeline {
    agent any
    
    stages {
        stage('Checkout') {
            steps {
                // Check out the code from GitHub
                rd /s /q Expense-Tracker
                bat 'git clone https://github.com/suyash172003/Expense-Tracker.git'
            }
        }
        
        stage('Build') {
            steps {
                // Build the project (for a Java project using Maven)
                bat 'mvn clean install'
            }
        }
        
        stage('Test') {
            steps {
                // Run unit tests
                bat 'mvn test'
            }
        }
    }
}
