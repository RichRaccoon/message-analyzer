package liga.medical.medicalanalyzer.core.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import liga.medical.common.dto.RabbitMessageDTO;
import liga.medical.medicalanalyzer.api.RabbitMessageSenderService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
public class RabbitMessageSenderServiceImpl implements RabbitMessageSenderService {
    private final AmqpTemplate amqpTemplate;

    private final ObjectMapper objectMapper;

    public RabbitMessageSenderServiceImpl(AmqpTemplate amqpTemplate, ObjectMapper objectMapper) {
        this.amqpTemplate = amqpTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public void sendMessage(RabbitMessageDTO rabbitMessageDTO, String queue) throws JsonProcessingException {
        String messageStr = objectMapper.writeValueAsString(rabbitMessageDTO);
        amqpTemplate.convertAndSend(queue, messageStr);
        System.out.println(String.format("Сообщение [%s] отправлено в очередь [%s]", messageStr, queue));
    }
}
