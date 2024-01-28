#!/usr/bin/env bash

PROJECT_ROOT="/home/ubuntu/app"
JAR_FILE="$PROJECT_ROOT/spring-webapp.jar"

APP_LOG="$PROJECT_ROOT/application.log"
ERROR_LOG="$PROJECT_ROOT/error.log"
DEPLOY_LOG="$PROJECT_ROOT/deploy.log"

TIME_NOW=$(date +%c)

# Copy build file
echo "$TIME_NOW > Copy file from $PROJECT_ROOT/build/libs/*.jar to $JAR_FILE" >> $DEPLOY_LOG
cp $PROJECT_ROOT/build/libs/*.jar $JAR_FILE

# Checking if the JAR file exists
if [ -f "$JAR_FILE" ]; then
    echo "$TIME_NOW > JAR file found, proceeding to execution" >> $DEPLOY_LOG

    # Run jar file
    echo "$TIME_NOW > Execute file $JAR_FILE" >> $DEPLOY_LOG
    nohup java -jar $JAR_FILE > $APP_LOG 2> $ERROR_LOG &

    CURRENT_PID=$(pgrep -f $JAR_FILE)
    echo "$TIME_NOW > The executed process ID is $CURRENT_PID." >> $DEPLOY_LOG
else
    echo "$TIME_NOW > JAR file not found, check the build process" >> $DEPLOY_LOG
fi
