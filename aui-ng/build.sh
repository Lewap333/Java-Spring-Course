echo "Building ng app..."

npm install
npm run build

docker build -t aui-ng .

echo "Building ng app finished!"