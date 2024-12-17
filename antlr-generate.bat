@echo off
set SAVECLASSPATH=%CLASSPATH%

set CLASSPATH=lib/antlr-4.9.1-complete.jar
"D:\developer_tools\Java\jdk-15\bin\java" org.antlr.v4.Tool -visitor -o src/logoparsing  grammar/Logo.g4
rem java org.antlr.v4.Tool -visitor -o src/logoparsing  grammar/Logo.g4
pause

set CLASSPATH=%SAVECLASSPATH%
 