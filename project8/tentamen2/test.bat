@echo off
javac *.java
javadoc *.java -d doc
java app
pause
echo on