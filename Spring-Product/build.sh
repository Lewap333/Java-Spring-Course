#!/bin/bash

set -e

echo "==>Starting mvm clean package..."
mvn clean package

echo "==> Building Docker image aui-product..."
docker build -t aui-product .

echo "==> Ready! aui-product built successfully."
