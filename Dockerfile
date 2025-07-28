FROM tomcat:9.0

# Clean the default Tomcat webapps
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy your full SmartSpend project into ROOT (for direct access)
COPY . /usr/local/tomcat/webapps/ROOT

# Copy additional libraries (JARs) to Tomcat's lib folder
COPY lib/*.jar /usr/local/tomcat/lib/

# Expose port
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]
