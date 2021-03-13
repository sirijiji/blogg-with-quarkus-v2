# blogg-with-quarkus-v2 project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `blogg-with-quarkus-v2-1.0.0-SNAPSHOT-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar target/blogg-with-quarkus-v2-1.0.0-SNAPSHOT-runner.jar`.

## After install GRAALVM

install gu
```shell script
cd F:\graalvm-ce-java11-20.2.0\bin
```
```shell script
${GRAALVM_HOME}/bin/gu install native-image
```

## Creating a native executable

You can create a native executable using (windows CMD): 
- open windows cmd (if on windows)
- change directory to this project
- run this command line
```shell script
call "C:\Program Files (x86)\Microsoft Visual Studio\2017\BuildTools\VC\Auxiliary\Build\vcvars64.bat" && mvn package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

## Creating a docker image with the native executable
```shell script
docker build -f src/main/docker/Dockerfile.native -t sirijiji/blogg-with-quarkus2 .
```
You can then execute your native executable with: `./target/blogg-with-quarkus-v2-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.html.

# RESTEasy JAX-RS

Guide: https://quarkus.io/guides/rest-json


