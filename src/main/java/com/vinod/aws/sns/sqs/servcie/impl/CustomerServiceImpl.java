package com.vinod.aws.sns.sqs.servcie.impl;

import com.vinod.aws.sns.sqs.dto.CustomerCreatedEvent;
import com.vinod.aws.sns.sqs.event.CustomerEvent;
import com.vinod.aws.sns.sqs.model.Customer;
import com.vinod.aws.sns.sqs.servcie.ICustomerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerEvent customerEvent;

    /**
     * Add new customer.
     *
     * @param customer  - Customer object.
     * @return          - Persisted customer object.
     */
    @Override
    public Customer addCustomer(Customer customer) {
        log.trace("Request came to add new customer : {}",customer);
        //Saved the customer to DB.
        log.trace("Successfully saved customer object and persisted object: {}",customer);
        customerEvent.on(CustomerCreatedEvent.builder().firstName(customer.getFirstName()).emailId(customer.getEmailId()).build());
        log.trace("Successfully raised the event for customer created: {}",customer.getEmailId());
        return customer;
    }
}
