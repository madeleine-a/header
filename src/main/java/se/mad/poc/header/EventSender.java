package se.mad.poc.header;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import se.atg.lib.stacklog.annotation.LogExclude;
import se.atg.lib.stacklog.annotation.LogStack;

@Service
public class EventSender {
    private JmsTemplate jmsTemplate;
private ObjectMapper mapper;
    public EventSender(JmsTemplate jmsTemplate, ObjectMapper objectMapper) {
        this.jmsTemplate = jmsTemplate;
        this.mapper = objectMapper;
    }

    @LogStack
    public void sendEvent(@LogExclude Model model) throws JsonProcessingException {
        jmsTemplate.convertAndSend("the-line", mapper.writeValueAsString(model));
    }
}
