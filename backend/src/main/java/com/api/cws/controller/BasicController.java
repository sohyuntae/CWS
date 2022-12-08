package com.api.cws.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class BasicController {

    @RequestMapping("/test")
    public boolean testApplication() throws IOException {
        return false;
    }
}
