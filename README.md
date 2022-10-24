# AWS Lambda with JAVA
<br><br>
## 현재 프로젝트 목적
백발백준 프로젝트를 기존에는 EC2 서버를 사용하여 24시간 대기하는 형태로 배포. 그러나 비용의 문제 때문에 현재 배포 중단한 상태.<br>
비용 때문에 대표적인 serverless 서비스인 `AWS Lambda`를 사용하여 요청이 발생할 때만 동작시킬려고 함. 그러나 현재 aws lambda에 대한 이해도가 낮기 때문에 연습을 목적으로 현 프로젝트를 생성하게 됨.
<br><br>
## Dependency and Version
```text
== AWS ==
aws lambda java core
aws lambda java events
aws lambda java log4j2

== Spring ==
spring boot starter
spring boot starter test
spring cloud starter function web // for local testing
spring cloud function adapter aws 

== Java ==
lombok
Java 8
```
<br><br>
## Deployment
```shell
./gradlew buildZip
```
aws lambda 에 배포하기 위해서 zip file로 빌드
<br><br>

```shell
cd build/distributions/
```
zip file가 존재하는 directory로 이동
<br><br>

```shell
aws lambda update-function-code --function-name {My_AWS_Lambda_FUNCTION_NAME} --zip-file fileb://{PROJECT_ZIP_FILE}
```
My_AWS_Lambda_FUNCTION_NAME : AWS Lambda에 만든 Function 이름 <br>
PROJECT_ZIP_FILE : 아까 빌드한 zip file