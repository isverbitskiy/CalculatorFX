#!/bin/bash

# Запуск виртуального фреймбуфера Xvfb
echo "Запуск Xvfb..."
Xvfb :99 -screen 0 1024x768x16 &

# Установка переменной окружения DISPLAY
export DISPLAY=:99

# Небольшая задержка для запуска Xvfb
sleep 5

# Проверка работы Xvfb
echo "Проверка работы Xvfb..."
xdpyinfo -display :99

# Запуск Java-приложения
echo "Запуск Java-приложения..."
java --module-path $JAVAFX_HOME/lib --add-modules=javafx.controls,javafx.fxml -jar /app/calculator.jar

# Если приложение зависло, то мы сможем проверить error.log для отладки
tail -f error.log