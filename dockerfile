# Etapa de construcción
FROM gradle:8.11.1-jdk21 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon -x test

# Etapa final
FROM eclipse-temurin:21-jre
# Exponer el puerto
EXPOSE 8081
# Crear directorio de la aplicación
RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/*.jar weatherapi.jar
# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "weatherapi.jar"]
