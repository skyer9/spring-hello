package com.example.hello;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @Value("${app.static-base-url}")
    private String staticBaseUrl;

    @Value("${app.version}")
    private String version;

    private final String hostname = System.getenv().getOrDefault("HOSTNAME", "local");

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("staticBaseUrl", staticBaseUrl);
        model.addAttribute("version", version);
        model.addAttribute("hostname", hostname);
        return "index";
    }

    @GetMapping("/api/hello")
    @ResponseBody
    public Map<String, String> hello() {
        return Map.of(
                "message", "Hello, World!",
                "version", version,
                "pod", hostname);
    }
}