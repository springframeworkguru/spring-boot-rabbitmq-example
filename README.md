# spring-boot-rabbitmq-example


Things to be checked before starting the application:
1. Update the application.properties file with your MySQL username and password
2. Create a new database schema with name springboot_rabbitmq_example
3. Update the spring.datasource.url if you are using a remote database.
4. Ensure that you have a rabbitmq server running and correctly configured in application.properties

Application flow 
1. Once the application is started, open the same in a browser http://localhost:8080
2. Create a new Product record
3. Notice that the value for "Are Mails Sent" in the http://localhost:8080/product/show/1 is currently set to false.
4. There is a link at the bottom of this record "Send emails through queue listener"
5. When this link is clicked, a message is put in a rabbitmq queue. 
6. This message is read and processed by MailSender class.
7. We have added a sleep of 10 seconds in MailSender.receiveMesage() to replicate a slow mail sending process.
8. On the browser, keep refreshing the page: http://localhost:8080/product/show/1 
9. You will notice that the value for "Are Mails Sent" changes to true after 10 seconds. 