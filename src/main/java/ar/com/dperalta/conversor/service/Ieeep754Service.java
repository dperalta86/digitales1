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

    public float ieee754ToFloat(String sign, String exponent, String mantissa) {
        int intBits = Integer.parseUnsignedInt(sign + exponent + mantissa, 2);
        return Float.intBitsToFloat(intBits);
    }
}
