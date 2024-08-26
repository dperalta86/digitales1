package ar.com.dperalta.conversor.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class Ieeep754Service {
    public Map<String, String> floatToIEEE754(float value) {
        int intBits = Float.floatToIntBits(value);
        String binaryString = Integer.toBinaryString(intBits);
        String paddedBinaryString = String.format("%32s", binaryString).replace(' ', '0');

        String sign = paddedBinaryString.substring(0, 1);
        String exponent = paddedBinaryString.substring(1, 9);
        String mantissa = paddedBinaryString.substring(9);

        Map<String, String> result = new HashMap<>();
        result.put("sign", sign);
        result.put("exponent", exponent);
        result.put("mantissa", mantissa);

        return result;
    }

    public float convertIeee754ToFloat(String bits) {
        // Convertir la cadena de 32 bits a un entero sin signo
        int intBits = Integer.parseUnsignedInt(bits, 2);

        // Convertir el entero a float usando Float.intBitsToFloat()
        return Float.intBitsToFloat(intBits);
    }
}
