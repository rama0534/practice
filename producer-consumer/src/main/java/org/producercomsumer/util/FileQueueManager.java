package org.producercomsumer.util;

import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

@Component
public class FileQueueManager {
    private final BlockingQueue<String> queue = new PriorityBlockingQueue<>();

    public void produce(String id) {
        queue.offer(id);
    }

    public String consume() throws InterruptedException {
        return queue.take();
    }
}
