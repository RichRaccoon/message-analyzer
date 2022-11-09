package liga.medical.medicalanalyzer.core.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import liga.medical.common.core.annotation.DbLog;
import liga.medical.common.dto.RabbitMessageDTO;
import liga.medical.medicalanalyzer.api.RabbitMessageSenderService;
import liga.medical.medicalanalyzer.core.config.RabbitConfig;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class RabbitMessageController {
    private final RabbitMessageSenderService rabbitMessageSenderService;

    public RabbitMessageController(RabbitMessageSenderService rabbitMessageSenderService) {
        this.rabbitMessageSenderService = rabbitMessageSenderService;
    }

    @PostMapping("/send")
    @DbLog
    public void sendMessage(@RequestBody RabbitMessageDTO message) throws JsonProcessingException {
        rabbitMessageSenderService.sendMessage(message, RabbitConfig.COMMON_QUEUE_NAME);
    }
}
