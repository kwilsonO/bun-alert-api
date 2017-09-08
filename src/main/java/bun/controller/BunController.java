package bun.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BunController {


    @RequestMapping("/healthz")
    public String healthz() {
        return "The bunnies are all healthy!";
    }
}
