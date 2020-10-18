package com.vinod.aws.sns.sqs.controller;

import com.vinod.aws.sns.sqs.model.Customer;
import com.vinod.aws.sns.sqs.servcie.ICustomerService;
import com.vinod.aws.sns.sqs.util.Response;
import lombok.extern.log4j.Log4j2;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.vinod.aws.sns.sqs.util.GlobalUtility.buildResponseForError;
import static com.vinod.aws.sns.sqs.util.GlobalUtility.buildResponseForSuccess;

@RestController
@RequestMapping("/customers")
@Log4j2
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @PostMapping
    public ResponseEntity<Response> addNewCustomer(@RequestBody Customer customer) {
        log.trace("Request came to add new customer with following details: {}", customer);
        Customer persistedCustomer=customerService.addCustomer(customer);
        if(null!=persistedCustomer) {
            return buildResponseForSuccess(HttpStatus.SC_OK,"Successfully added new customer",persistedCustomer);
        }
        return buildResponseForError(HttpStatus.SC_INTERNAL_SERVER_ERROR, String.valueOf(HttpStatus.SC_INTERNAL_SERVER_ERROR),"Unable to add the customer.",null);
    }
}
