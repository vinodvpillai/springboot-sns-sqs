package com.vinod.aws.sns.sqs.event;

import com.vinod.aws.sns.sqs.dto.CustomerCreatedEvent;
import com.vinod.aws.sns.sqs.servcie.IPublisherService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class CustomerEvent {
    @Autowired
    private IPublisherService publisherEventService;

    @Value("${sns.topic.customer.created}")
    private String snsCustomerCreated;

    public void on(CustomerCreatedEvent customer) {
        log.trace("Request came to raise event for customer created: {}",customer);
        try{
            publisherEventService.publish(snsCustomerCreated,customer,"Customer_Created");
            log.info("Successfully publish message for customer created: {}",customer);
        } catch (Exception e) {
            log.trace("Error occurred while raising event for customer created: {}",customer);
        }
    }

}
