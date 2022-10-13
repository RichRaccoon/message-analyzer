package liga.medical.medicalanalyzer.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import liga.medical.common.dto.RabbitMessageDTO;

public interface RabbitMessageSenderService {
    void sendMessage(RabbitMessageDTO rabbitMessageDTO, String queue) throws JsonProcessingException;
}
