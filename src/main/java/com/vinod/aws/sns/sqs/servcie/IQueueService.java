package com.vinod.aws.sns.sqs.servcie;

public interface IQueueService {

    public void sendMessage(String queue, String message);
}
