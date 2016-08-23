package gaddam1987.github.learning.even.listener;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.*;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ApplicationEventListener {

    @EventListener(classes = {ContextStartedEvent.class})
    public void contextStart() {
        log.info("Event fired {}", ContextStartedEvent.class);
    }


    @EventListener(classes = {ContextStoppedEvent.class})
    public void contextStopped() {
        log.info("Event fired {}", ContextStoppedEvent.class);
    }


    @EventListener(classes = {ContextRefreshedEvent.class})
    public void contextRefresh() {
        log.info("Event fired {}", ContextRefreshedEvent.class);
    }


    @EventListener(classes = {ContextClosedEvent.class})
    public void contextClosed() {
        log.info("Event fired {}", ContextClosedEvent.class);
    }

}
