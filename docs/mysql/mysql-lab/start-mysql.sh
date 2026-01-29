#!/bin/bash

echo "Starting MySQL container..."
docker-compose up -d

echo "Waiting for MySQL to initialize..."
sleep 15

echo "MySQL is ready!"
echo "Use below command to login:"
echo "docker exec -it mysql-practice mysql -u dev -pdev123 practice_db"
