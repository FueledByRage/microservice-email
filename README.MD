# Send Email Microservice with Java Spring Boot

# About it

It's just a simple microservice i've coded to help in my projects. It's take message and send it throught SMTP.

# How to use it

Firstly, generate a application password on your [google account page](https://myaccount.google.com/), you can follow [this](https://support.google.com/accounts/answer/185833) tutorial

Change the spring.mail.username and spring.mail.password values from the application.properties for your email and just generated application password

Make sure to run a Mysql server with credentials that fit the application.properties file

Run the SendEmailApplication.java

## HTTP

The default endpoint is on port 4000.

http://localhost:4000

By now the send email route is the only one 

ENDPOINT | METHOD | PARAMS | EXPECTED SUCCESS | EXPECTED ERROR
---------|--------|--------|------------------|---------------|
/sending-email | POST | emailOwner, emailTo, subject, text | 200 | Error message

## Message Broker

The ms also consume a rabbitmq message broker, taking message from the ms.email queue, you can run a rabbitmq service and publish a message that fits the message params.