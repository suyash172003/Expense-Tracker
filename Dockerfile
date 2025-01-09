FROM openjdk
WORKDIR /app
COPY target/Expense-0.0.1-SNAPSHOT.jar .
EXPOSE 8081
CMD ["java","-jar","/app/Expense-0.0.1-SNAPSHOT.jar"]