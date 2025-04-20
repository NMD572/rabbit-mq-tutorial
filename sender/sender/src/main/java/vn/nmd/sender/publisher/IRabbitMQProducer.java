package vn.nmd.sender.publisher;

public interface IRabbitMQProducer {
	public void sendMessage(String message);
}
