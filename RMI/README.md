## How to change java versions?

1. Type the following command in the Terminal window to see the current Java version:
    ```
    java -version
    ```

2. If you have multiple Java versions installed on your Mac, you can list them by typing the following command:
    ```
    /usr/libexec/java_home -V
    ```

3. To change the Java version, you need to set the JAVA_HOME environment variable to the path of the Java installation directory that you want to use. You can do this by typing the following command in the Terminal window:
    ```
    export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-16.0.2.jdk/Contents/Home
    ```
    (Note: Replace the path in this command with the path to the Java installation directory that you want to use.)

4. To verify that the JAVA_HOME environment variable has been set correctly, type the following command in the Terminal window:
    ```
    echo $JAVA_HOME
    ```

5. To make this change persistent across Terminal sessions, add the export command to your ~/.bash_profile file. You can do this by typing the following command in the Terminal window:
    ```
    echo "export JAVA_HOME=/Library/Java/JavaVirtualMachines/JDK-16.0.2.jdk/Contents/Home" >> ~/.bash_profile
    ```
    (Note: Replace the path in this command with the path to the Java installation directory you want to use.)

## How to run the code?

1. Before you can run the server program, you need to start the RMI registry:
    ```
    rmiregistry
    ```

2. The server program creates an instance of the remote object, registers it with the RMI registry, and waits for incoming client requests:
    ```
    javac *.java
    java RMI.sample.MyServer
    ```

3. The client program looks up the remote object in the RMI registry and invokes the remote method on it:
    ```
    java RMI.sample.Client
    ``` 

