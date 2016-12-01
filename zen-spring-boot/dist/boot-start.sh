#!/bin/bash

# 接收可执行jar包路径参数，不能为空
# 设置JDK根目录路径，请根据环境修改
JAVA_HOME="/home/appadmin/local/jdk1.8.0_91"

export PATH=$JAVA_HOME/bin:$PATH

java -jar $1


# 备注：
# -bash: ./boot-start.sh: /bin/bash^M: bad interpreter: 没有那个文件或目录
# 出现这个错误是因为在windows下编辑的脚步格式为dos，需要改为unix才能执行
# vi 打开脚本，输入:set ff? 查看如果是dos， 运行:set ff=unix 可解决
