pipeline {
    agent any

    stages {  
        stage("build") {
            steps {
                echo 'Building application ....'
                echo "Application built"
            }
        }

        stage("test") {
            steps {
                echo 'Testing application .....'
            }
        }

        stage("deploy") {
            steps {
                echo 'Deploying application '
            }
        }
    }
}
