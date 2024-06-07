# Используем базовый образ Ubuntu 22.04 для ARM64
FROM arm64v8/ubuntu:22.04

# Установка необходимых пакетов
RUN apt-get update && apt-get install -y \
    openjdk-17-jdk \
    unzip \
    wget \
    xvfb \
    libx11-6 \
    libxext6 \
    libxrender1 \
    libxtst6

# Скачивание и распаковка JavaFX SDK
RUN wget https://download2.gluonhq.com/openjfx/22.0.1/openjfx-22.0.1_linux-aarch64_bin-sdk.zip -O javafx.zip && \
    unzip javafx.zip && \
    mv javafx-sdk-22.0.1 /opt/javafx-sdk-22.0.1 && \
    rm javafx.zip

# Установка переменной окружения для JavaFX
ENV JAVAFX_HOME=/opt/javafx-sdk-22.0.1

# Установка рабочей директории
WORKDIR /app

# Копирование JAR файла
COPY target/calculator-1.0-SNAPSHOT-jar-with-dependencies.jar /app/calculator.jar

# Копирование стартового скрипта
COPY start.sh /app/start.sh

# Назначение прав на выполнение скрипта
RUN chmod +x /app/start.sh

# Указание команды для запуска приложения
CMD ["/app/start.sh"]