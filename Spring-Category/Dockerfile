FROM eclipse-temurin:17.0.6_10-jre

ENV SERVER_PORT=8080

# Konfiguracja źródła danych H2
ENV SPRING_DATASOURCE_URL=jdbc:h2:mem:aui-category
ENV SPRING_DATASOURCE_DRIVERCLASSNAME=org.h2.Driver
ENV SPRING_DATASOURCE_USERNAME=admin
ENV SPRING_DATASOURCE_PASSWORD=password

# Konfiguracja JPA
ENV SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.H2Dialect
ENV SPRING_JPA_GENERATE_DDL=true
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update

# Włączenie konsoli H2
ENV SPRING_H2_CONSOLE_ENABLED=true

# URL produkt
ENV AUI_PRODUCT_URL=http://localhost:8081

# Expose port aplikacji
EXPOSE ${SERVER_PORT}

COPY target/AUI-0.0.1-SNAPSHOT.jar /opt/AUI-0.0.1-SNAPSHOT.jar

CMD ["java", "-jar", "/opt/AUI-0.0.1-SNAPSHOT.jar"]