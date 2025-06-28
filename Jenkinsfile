// This declares the start of a Jenkins Declarative Pipeline
pipeline {

    // 'agent any' means Jenkins can run this pipeline on any available node or agent
    agent any

    // This defines a parameter that will be visible when you click "Build with Parameters" in Jenkins
    // You can choose which browser to run the tests on (like chrome, edge, firefox, etc.)
    parameters {
        string(name: 'browser', defaultValue: 'chrome', description: 'Browser to run tests on')
    }

    // These are the main stages shown in Stage View (like you saw in the screenshot)
    stages {

        // STAGE 1: Clones your code from GitHub (or any Git repo)
        stage('Checkout Code') {
            steps {
                // Replace the Git URL with your actual repo URL
                git branch: 'main',
                    url: 'https://github.com/your-org/your-repo.git'
            }
        }

        // STAGE 2: Builds your Maven project (compiles Java code)
        stage('Build Project') {
            steps {
                // mvn clean = clean up previous builds
                // mvn compile = compile Java classes
                // -DskipTests = skip running tests in this stage
                sh 'mvn clean compile -DskipTests'
            }
        }

        // STAGE 3: Executes your Selenium test cases using the selected browser
        stage('Run Tests on Selected Browser') {
            steps {
                // This command runs test cases and passes the browser value as a system property
                // In your Java code, you’ll read it using: System.getProperty("browser")
                sh "mvn test -Dbrowser=${browser}"
            }
        }
    }

    // These are actions that run after the pipeline finishes
    post {

        // Prints a message in the console if build is successful
        success {
            echo '✅ Build completed successfully.'
        }

        // Prints a message in the console if build fails
        failure {
            echo '❌ Build failed.'
        }
    }
}
