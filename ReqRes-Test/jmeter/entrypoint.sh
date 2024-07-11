#!/bin/bash

# Execute JMeter test
jmeter -n -t /test/Request_Api.jmx -l /test/resultados.jtl -e -o /test/reporte

# Copy JMeter report to nginx html directory
cp -r /test/reporte/* /var/www/html/

# Start nginx
nginx -g 'daemon off;'

#docker run --rm -v ${PWD}:/test -p 8080:80 jmeter-nginx