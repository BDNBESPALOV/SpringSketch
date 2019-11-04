#!/usr/bin/env bash

mvn clean package

echo 'Copy files...'

scp -i ~/.ssh/id_rsa  \
target/bdn-1.0-SNAPSHOT.jar \
root@192.168.56.102:/u01/site/

echo 'Host save...'

ssh -i ~/.ssh/id_rsa root@192.168.56.102 << EOF
pgrep java | xargs kill -9
nohup java -jar bdn-1.0-SNAPSHOT.jar > log.txt &
EOF

echo 'Bye'