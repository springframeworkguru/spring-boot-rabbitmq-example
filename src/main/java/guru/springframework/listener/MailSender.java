package guru.springframework.listener;

import guru.springframework.domain.Product;
import guru.springframework.repositories.ProductRepository;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * This is the queue listener class, its receiveMessage() method ios invoked with the
 * message as the parameter.
 */
@Component
public class MailSender {

    private ProductRepository productRepository;

    private static final Logger log = Logger.getLogger(MailSender.class);

    public MailSender(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * This method is invoked whenever any new message is put in the queue.
     * See {@link guru.springframework.SpringBootRabbitMQApplication} for more details
     * @param message
     */
    public void receiveMessage(Map<String, String> message) {
        log.info("Received <" + message + ">");
        Long id = Long.valueOf(message.get("id"));
        Product product = productRepository.findOne(id);
        product.setMailsSent(true);

        log.info(
          "Receiver is sleeping for 10 seconds to simulate mail sending process");
        try {
            Thread.currentThread().sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        productRepository.save(product);
        log.info("Sent all emails...");
    }
}
