
package com.platformpublisher;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    @RequestMapping(value="/")
    public String welcome(){
        return "Hello World! Welcome to Spring boot!";
    
    
    }
    
}
