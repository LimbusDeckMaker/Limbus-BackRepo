#!/usr/bin/env bash

PROJECT_ROOT="/home/ubuntu/app"
JAR_FILE="$PROJECT_ROOT/spring-webapp.jar"

DEPLOY_LOG="$PROJECT_ROOT/deploy.log"

TIME_NOW=$(date +"%Y-%m-%d %H:%M:%S")

# 현재 구동 중인 애플리케이션 pid 확인
if [ -f "$PROJECT_ROOT/pid.file" ]; then
    CURRENT_PID=$(cat $PROJECT_ROOT/pid.file)
    if [ -n "$CURRENT_PID" ]; then
        echo "$TIME_NOW > 실행중인 $CURRENT_PID 애플리케이션 종료 " >> $DEPLOY_LOG
        kill -15 $CURRENT_PID
        rm -f $PROJECT_ROOT/pid.file
    else
        echo "$TIME_NOW > 현재 실행중인 애플리케이션이 없습니다" >> $DEPLOY_LOG
    fi
else
    echo "$TIME_NOW > PID file not found, assuming no application is running." >> $DEPLOY_LOG
fi