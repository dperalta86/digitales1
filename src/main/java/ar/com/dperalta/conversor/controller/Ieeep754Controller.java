package ar.com.dperalta.conversor.controller;

import ar.com.dperalta.conversor.service.Ieeep754Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "/ieeep754simple")
public class Ieeep754Controller {
    @Autowired
    private Ieeep754Service ieeep754Service;

    @PostMapping("/float")
    public ResponseEntity<Map<String, String>> convertFloatToIEEE754(@RequestBody Map<String, Float> request) {
        Float value = request.get("float");
        Map<String, String> result = ieeep754Service.floatToIEEE754(value);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/ieee")
    public float ieee754ToFloat(@RequestBody String sign, @RequestBody String exponent, @RequestBody String mantissa) {
        return ieeep754Service.ieee754ToFloat(sign, exponent, mantissa);
    }
}
