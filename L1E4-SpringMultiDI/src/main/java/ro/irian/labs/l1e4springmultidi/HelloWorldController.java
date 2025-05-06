package ro.irian.labs.l1e4springmultidi;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hello")
public class HelloWorldController {

    @GetMapping("/{name}")
    public String hello(@PathVariable String name) {
        return "Hello " + name + "!"  ;
    }

    @GetMapping()
    public String helloParam(@RequestParam String name) {
        return "Hello filtered " + name + "!"  ;
    }

    @GetMapping("world")
    public String helloWorld() {
        return "Hello World!";
    }

}
