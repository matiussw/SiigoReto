# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jre

# Set environment variables
ENV JMETER_VERSION 5.4.3
ENV JMETER_HOME /opt/apache-jmeter-${JMETER_VERSION}
ENV PATH $JMETER_HOME/bin:$PATH

# Install JMeter
RUN wget -q https://archive.apache.org/dist/jmeter/binaries/apache-jmeter-${JMETER_VERSION}.tgz && \
    tar -xzf apache-jmeter-${JMETER_VERSION}.tgz -C /opt && \
    rm apache-jmeter-${JMETER_VERSION}.tgz

# Install nginx
RUN apt-get update && apt-get install -y nginx && \
    rm -rf /var/lib/apt/lists/*

# Copy entrypoint script
COPY entrypoint.sh /entrypoint.sh
RUN chmod +x /entrypoint.sh

# Copy nginx configuration
COPY nginx.conf /etc/nginx/nginx.conf

# Expose port 80 for nginx
EXPOSE 80

# Set entrypoint
ENTRYPOINT ["/entrypoint.sh"]
