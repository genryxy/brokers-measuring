package ru.hse.babds.artemis.config;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import ru.hse.babds.artemis.model.Person;

@Component
public class ArtemisConsumerConfig { //  implements MessageConverter {

    @JmsListener(destination = "${jms.queue.destination}")
    public void receiveArtemis(Message message){
        if(message.getPayload() instanceof String){
            System.out.println("Recieved Message: " + message.getPayload().toString());
        }else if (message.getPayload() instanceof Person){
            System.out.println("Recieved Person: " + message.getPayload().toString());
        }else {
            System.err.println("Message Type Unkown !");
        }
    }

/*

	@Override
	public Object fromMessage(Message<?> message, Class<?> targetClass) {
		System.out.println("from Message.getPayload() = " + message.getPayload().toString());
		return  message;
	}

	@Override
	public Message<?> toMessage(Object payload, MessageHeaders headers) {
		System.out.println("to Message.getPayload() = " + payload.toString());
		return (Message<Person>) ( payload );
	}

*/

}
