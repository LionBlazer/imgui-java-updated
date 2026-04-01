@echo off
setlocal

set "GRADLE_LIB_DIR=E:\Users\white\.gradle\wrapper\dists\gradle-8.14.3-bin\cv11ve7ro1n3o1j4so8xd9n66\gradle-8.14.3\lib"
set "ANT_LAUNCHER_JAR=%GRADLE_LIB_DIR%\ant-launcher-1.10.15.jar"
set "ANT_JAR=%GRADLE_LIB_DIR%\ant-1.10.15.jar"

if not exist "%ANT_LAUNCHER_JAR%" (
    echo Unable to locate "%ANT_LAUNCHER_JAR%". 1>&2
    exit /b 1
)

if not exist "%ANT_JAR%" (
    echo Unable to locate "%ANT_JAR%". 1>&2
    exit /b 1
)

java -cp "%ANT_LAUNCHER_JAR%;%ANT_JAR%" org.apache.tools.ant.launch.Launcher %*
