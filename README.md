# spring-boot-rabbitmq-example


Things to be checked before starting the application:

* Update the application.properties file with your MySQL username and password
* Create a new database schema with name springboot_rabbitmq_example
* Update the spring.datasource.url if you are using a remote database.
* Ensure that you have a rabbitmq server running and correctly configured in application.properties

Application flow:
 
* Once the application is started, open the same in a browser http://localhost:8080
* Create a new Product record
* Notice that the value for "Are Mails Sent" in the http://localhost:8080/product/show/1 is currently set to false.
* There is a link at the bottom of this record "Send emails through queue listener"
* When this link is clicked, a message is put in a rabbitmq queue, the browser is redirected back to the product show page without getting blocked. 
* This message is read and processed by MailSender class.
* We have added a sleep of 10 seconds in MailSender.receiveMesage() to replicate a slow mail sending process.
* On the browser, keep refreshing the page: http://localhost:8080/product/show/1 
* You will notice that the value for "Are Mails Sent" changes to true after 10 seconds. 