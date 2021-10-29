package se.mad.poc.header;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import se.atg.lib.stacklog.annotation.LogStack;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping(value = "/", produces = APPLICATION_JSON_VALUE)
@Slf4j
public class Api {
    private EventSender eventSender;

    public Api(EventSender eventSender) {
        this.eventSender = eventSender;
    }

    @PostMapping("posta")
    @LogStack
    public void postData(@RequestBody Model model) throws JsonProcessingException {

        eventSender.sendEvent(model);
    }

    @LogStack
    @GetMapping("getta")
    public Model getData() {
        return new Model("hej", "men nej");
    }
}
