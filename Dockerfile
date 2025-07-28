# Use an official Tomcat base image
FROM tomcat:9.0

# Remove default webapps
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy your app to the ROOT webapp directory
COPY . /usr/local/tomcat/webapps/ROOT

# Copy SQLite JDBC driver to Tomcat's lib
COPY lib/sqlite-jdbc-3.43.2.2.jar /usr/local/tomcat/lib/

# Expose Tomcat port
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]
