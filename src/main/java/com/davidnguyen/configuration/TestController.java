package com.davidnguyen.configuration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final Environment env;

    @GetMapping("/test")
    public String test() throws JsonProcessingException {
        Map<String, String> info = new HashMap<>();
        info.put("URL", env.getProperty("spring.datasource.url"));
        info.put("USERNAME", env.getProperty("spring.datasource.username"));
        info.put("PASSWORD", env.getProperty("spring.datasource.password"));
        return new ObjectMapper().writeValueAsString(info);
    }
}
