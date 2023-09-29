# FROM : base image
FROM openjdk:17-oracle AS builder
RUN microdnf install findutils
# COPY : 해당 경로의 파일을 volume에 저장
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src
# RUN :gradlew 실행 권한 부여 및 gradlew를 통해 실행 가능한 ja팅r파일 생성
RUN chmod +x ./gradlew
RUN ./gradlew bootJar

FROM openjdk:17-oracle
# build이미지에서 build/libs/*.jar 파일을 app.jar로 복사
COPY --from=builder build/libs/*.jar app.jar

# jar 파일 실행
ENTRYPOINT ["java", "-jar", "/app.jar"]
# 볼륨 지정
VOLUME /booklog-review-data