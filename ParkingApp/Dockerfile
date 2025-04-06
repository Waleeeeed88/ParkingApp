FROM openjdk:24-jdk-slim

# Install required packages: Xvfb, Fluxbox, x11vnc, and basic X11 libraries
RUN apt-get update && apt-get install -y \
    xvfb \
    x11vnc \
    fluxbox \
    libx11-6 \
    && rm -rf /var/lib/apt/lists/*

WORKDIR /app

# Copy your pre-built JAR from the target folder
COPY target/ParkingApp-1.0-SNAPSHOT.jar /app/ParkingApp-1.0-SNAPSHOT.jar

# Expose the VNC port (set to 5901)
EXPOSE 8080

# Start Xvfb, Fluxbox, and x11vnc with additional delays, then set DISPLAY and launch the app
CMD ["sh", "-c", "\
  Xvfb :1 -screen 0 1024x768x16 & \
  sleep 5 && \
  fluxbox & \
  sleep 5 && \
  x11vnc -display :1 -nopw -listen 0.0.0.0 -rfbport 5901 -xkb & \
  sleep 5 && \
  export DISPLAY=:1 && \
  java -jar /app/ParkingApp-1.0-SNAPSHOT.jar"]
