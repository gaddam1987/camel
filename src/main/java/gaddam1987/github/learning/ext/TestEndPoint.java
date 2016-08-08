package gaddam1987.github.learning.ext;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.http.HttpStatus.ACCEPTED;

@Controller
@RequestMapping("/ext")
public class TestEndPoint {

    @RequestMapping("/ping")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<String>("polo", ACCEPTED);
    }
}
