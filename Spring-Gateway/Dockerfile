FROM eclipse-temurin:17.0.6_10-jre

ENV SERVER_PORT=8080

# URLs
ENV AUI_GATEWAY_HOST=localhost:8080
ENV AUI_PRODUCT_URL=http://localhost:8081
ENV AUI_CATEGORY_URL=http://localhost:8082

# Expose port aplikacji
EXPOSE ${SERVER_PORT}

COPY target/AUI-0.0.1-SNAPSHOT.jar /opt/AUI-0.0.1-SNAPSHOT.jar

CMD ["java", "-jar", "/opt/AUI-0.0.1-SNAPSHOT.jar"]