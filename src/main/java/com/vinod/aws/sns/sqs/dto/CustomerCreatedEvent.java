package com.vinod.aws.sns.sqs.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerCreatedEvent implements Serializable {

    private String firstName;
    private String emailId;
}
