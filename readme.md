# Build and run, package and run package

In project root folder, i.e. project01am
To compile
1. javac -d bin --source-path . ./*.java Card/*.java
   
To run the compile bytecode (.class) main entrypoint
java -cp bin <packageName>.<ClassName>
2. java -cp bin project01am.App 

To package into jar file, go into the bin folder
3. jar -c -v -f day09.jar -e project01am.App . 

To run the jar file inside the bin folder where the jar is created
4. java -jar day09.jar

To run the jar file in the project root folder (outside the bin folder)
5. java -jar bin/day09.jar