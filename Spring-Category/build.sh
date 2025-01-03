#!/bin/bash

set -e

echo "==>Starting mvm clean package..."
mvn clean package

echo "==> Building Docker image aui-category..."
docker build -t aui-category .

echo "==> Ready! aui-category built successfully."
