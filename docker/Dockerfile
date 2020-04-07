FROM openjdk:8-jre-alpine

ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    JHIPSTER_SLEEP=2

# add directly the war
ADD tgip-server-2.1.0-SNAPSHOT.jar /app.jar
#ADD config/application.yml /application.yml
#ADD config/application-dev.yml /application-dev.yml
#ADD config/bootstrap.yml /bootstrap.yml

ENV EUREKA_INSTANCE_IP-ADDRESS=192.168.8.155 \
	SERVER_PORT=11042

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai  /etc/localtime

VOLUME /tmp
EXPOSE 11042
CMD echo "The application will start in ${JHIPSTER_SLEEP}s..." && \
    sleep ${JHIPSTER_SLEEP} && \
    java -Djava.security.egd=file:/dev/./urandom -jar /app.jar
