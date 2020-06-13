#!/bin/sh
mvn -Dmaven.test.skip=true clean install
java -jar backend/target/backend-0.0.1-SNAPSHOT.jar