#!/bin/bash
cd /home/kavia/workspace/code-generation/smarthome-tv-dashboard-41039-41058/android_tv_frontend
./gradlew lint
LINT_EXIT_CODE=$?
if [ $LINT_EXIT_CODE -ne 0 ]; then
   exit 1
fi

