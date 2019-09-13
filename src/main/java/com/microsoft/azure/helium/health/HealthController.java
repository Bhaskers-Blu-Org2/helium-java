package com.microsoft.azure.helium.health;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

/*    @Autowired
    TestMeHealthEndpoint testMeHealthEndpoint;

    @ApiOperation(value="Health endpoint", notes = "Health endpoint")
    @RequestMapping(value = "/health", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
    public ResponseEntity<Health> invoke() {
        return ResponseEntity.ok(testMeHealthEndpoint.invoke());
    }*/
}