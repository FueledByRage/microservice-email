# Send Email Microservice with Java Spring Boot

# About it

It's just a simple microservice i've coded to help in my projects. It's take message and send it throught SMTP.

# How to use it

You must change the defaults value for the SMTP authentucatuib in the application.properties file and run a , mysql docker container  with the right credentials.

The default endpoint is on port 4000.

http://localhost:4000

By now the send email route is the only one 

ENDPOINT | METHOD | PARAMS | EXPECTED SUCCESS | EXPECTED ERROR
---------|--------|--------|------------------|---------------|
/sending-email | POST | emailOwner, emailFrom, emailTo, subject, text | 200 | Error message