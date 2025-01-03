#!/bin/bash

set -e

echo "==>Starting mvm clean package..."
mvn clean package

echo "==> Building Docker image aui-gateway..."
docker build -t aui-gateway .

echo "==> Ready! aui-gateway built successfully."
