package com.vinod.aws.sns.sqs.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Log4j2
public class Customer implements Serializable {

    private String firstName;
    private String lastName;
    private String emailId;
}
