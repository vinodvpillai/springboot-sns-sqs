package com.vinod.aws.sns.sqs.servcie;

import com.vinod.aws.sns.sqs.model.Customer;

public interface ICustomerService {

    /**
     * Add new customer.
     *
     * @param customer  - Customer object.
     * @return          - Persisted customer object.
     */
    Customer addCustomer(Customer customer);
}
