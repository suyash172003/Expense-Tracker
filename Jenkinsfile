pipeline {
    agent any

    stages {
        stage('Cleanup') {
            steps {
                bat 'rd /s /q Expense-Tracker'
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
