pipeline {
    agent any
    tools {
        maven 'Maven 3.9' // Name must match the Maven installation name in Jenkins configuration
    }

    stages {
        stage('Cleanup') {
            steps {
               if exist "C:\ProgramData\Jenkins\.jenkins\workspace\Expense Tracker\Expense-Tracker" (
                    rd /s /q "C:\ProgramData\Jenkins\.jenkins\workspace\Expense Tracker\Expense-Tracker"
                ) else (
                    echo "Directory not found"
                )
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
