package vn.nmd.receiver.consumer;

import vn.nmd.receiver.entity.Job;

public interface IRabbitMQConsumer {
	  public void consumeNmdFirstQueue(String message);
	  
	  public void consumeNmdJsonRoutingKey(Job job);
}
