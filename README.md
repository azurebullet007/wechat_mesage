# wechat_mesage

 messagesdk.java和整个sdk我之前使用IDEA创建的项目，那里是可以运行的，这边有两个包有问题好像是JDK8到11的问题。



bcp开头的两个文件是用来解压rsa加密过的文件的jar包

解决sun.security.util的编译问题可以在编译时候加上(主要是JDK8—>JDK11的问题)

--add-exports java.base/sun.security.util=ALL-UNNAMED
