FROM openjdk:24-jdk-slim


RUN apt-get update && apt-get install -y \
    xvfb \
    x11vnc \
    fluxbox \
    libx11-6 \
    && rm -rf /var/lib/apt/lists/*

WORKDIR /app

COPY target/ParkingApp-1.0-SNAPSHOT.jar /app/ParkingApp-1.0-SNAPSHOT.jar

EXPOSE 8080


CMD ["sh", "-c", "\
  Xvfb :1 -screen 0 1024x768x16 & \
  sleep 5 && \
  fluxbox & \
  sleep 5 && \
  x11vnc -display :1 -nopw -listen 0.0.0.0 -rfbport 5901 -xkb & \
  sleep 5 && \
  export DISPLAY=:1 && \
  java -jar /app/ParkingApp-1.0-SNAPSHOT.jar"]
