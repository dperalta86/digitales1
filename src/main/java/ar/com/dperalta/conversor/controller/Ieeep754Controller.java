package ar.com.dperalta.conversor.controller;

import ar.com.dperalta.conversor.service.Ieeep754Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "/ieeep754simple")
public class Ieeep754Controller {
    @Autowired
    private Ieeep754Service ieeep754Service;

    @PostMapping("/float")
    public Map<String, String> floatToIEEE754(@RequestBody float value) {
        return ieeep754Service.floatToIEEE754(value);
    }

    @PostMapping("/ieee")
    public float ieee754ToFloat(String sign, String exponent, String mantissa) {
        return ieeep754Service.ieee754ToFloat(sign, exponent, mantissa);
    }
}
