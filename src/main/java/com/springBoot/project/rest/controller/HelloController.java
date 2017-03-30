package com.springBoot.project.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @RequestMapping(value = "/say/{say}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String home(@PathVariable String say) {
        return "Hello " + say;
    }
}
