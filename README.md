# Spring Boot RabbitMQ Example


Things to be checked before starting the application:

* Update the application.properties file with your MySQL username and password
* Create a new database schema with name springboot_rabbitmq_example
* If you wish to used a different database / schema, you will need to override values in application.properties
* Ensure that you have a rabbitmq server running and correctly configured in application.properties (default is localhost:5671) )

Application flow:
 
* Once the application is started, a browser at http://localhost:8080
* Create a new Product record
* Notice that the value for "Is Message Sent" in the http://localhost:8080/product/show/1 is currently set to false.
* There is a link at the bottom of this record "Send messages through queue listener"
* When this link is clicked, a message is put in a rabbitmq queue, the browser is redirected back to the product show page without getting blocked. 
* This message is read and processed by MessageSender class.
* On the browser, keep refreshing the page: http://localhost:8080/product/show/1 
* You will notice that the value for "Are Messages Sent" changes to true in a second or so. 