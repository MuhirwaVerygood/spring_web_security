package org.example.springsecurity.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo-controller")
public class DemoControllers {

    @PostMapping
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("Helllo from the protected endpoint" );
    }
}
