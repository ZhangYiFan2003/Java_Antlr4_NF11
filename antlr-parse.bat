@echo off
set SAVECLASSPATH=%CLASSPATH%

set CLASSPATH=lib/antlr-4.9.1-complete.jar;./bin
"D:\developer_tools\Java\jdk-15\bin\java" org.antlr.v4.gui.TestRig logoparsing.Logo programme -gui programs/logo-prg.txt
rem java org.antlr.v4.gui.TestRig logoparsing.Logo programme -gui programs/logo-prg.txt
pause

set CLASSPATH=%SAVECLASSPATH%
