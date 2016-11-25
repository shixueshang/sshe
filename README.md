springmvc+spring+hibernate+bootstrap+metrnic4.7实现简单的增删改查功能3

将外部jar ueditor打入本地maven仓库方法：
1、cmd到jar所在路径
2、执行命令mvn install:install-file -Dfile=ueditor-1.1.2.jar -DgroupId=ueditor -DartifactId=ueditor -Dversion=1.1.2 -Dpackaging=jar
3、在pom添加依赖