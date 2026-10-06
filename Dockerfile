FROM eclipse-temurin:17-jre

WORKDIR /app
COPY build/libs/app.jar app.jar

# 컨테이너 메모리 limit 의 75% 를 힙으로 사용
ENV JAVA_TOOL_OPTIONS="-XX:MaxRAMPercentage=75"

# root 로 실행하지 않음 (숫자 UID 는 RUN useradd 없이도 사용 가능)
USER 1000:1000

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]