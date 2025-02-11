# Build stage: 使用 Maven 和 Java 17 构建应用
FROM maven:3.9-eclipse-temurin-17 AS builder
LABEL maintainer="6159984@gmail.com"
LABEL version="1.0"
LABEL description="This is a Spring Boot application built with Java 17"
WORKDIR /app

# 将 pom.xml 和源代码复制到容器中
COPY pom.xml .
COPY src ./src

# 使用 Maven 构建项目（跳过测试）
RUN mvn clean package -DskipTests

# Run stage: 运行构建的 JAR 文件
FROM eclipse-temurin:17-jre-jammy
LABEL maintainer="6159984@gmail.com"
LABEL version="1.0"
LABEL description="This is a Spring Boot application runtime container"
WORKDIR /app

# 将构建好的 JAR 文件从构建阶段复制到运行阶段
COPY --from=builder /app/target/*.jar app.jar

# 暴露应用端口
EXPOSE 8080

# 设置容器启动时运行的命令
ENTRYPOINT ["java", "-jar", "app.jar"]
