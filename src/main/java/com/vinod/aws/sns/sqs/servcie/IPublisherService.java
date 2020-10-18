package com.vinod.aws.sns.sqs.servcie;

public interface IPublisherService {

    <T> String publish(String topic, T msg, String subject);
}
