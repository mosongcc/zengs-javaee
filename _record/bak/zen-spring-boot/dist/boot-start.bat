@echo off

rem 接收可执行jar包路径参数，不能为空
rem 设置JDK根目录路径，请根据环境修改
set JAVA_HOME = "D:\local\Java\jre1.8.0_66"

set Path = "%Path%;%JAVA_HOME%\bin"
if exist %1% (
    java -jar %1%
) else (
    echo Error: '%1%' The file is not exist
)
pause


