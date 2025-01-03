echo "==> Building the app"
cd ./Spring-Product/; sh ./build.sh; cd ..
cd ./Spring-Category/; sh ./build.sh; cd ..
cd ./Spring-Gateway/; sh ./build.sh; cd ..
cd ./aui-ng/; sh ./build.sh; cd ..

echo "=> Building finished"