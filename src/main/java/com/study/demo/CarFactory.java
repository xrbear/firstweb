package com.study.demo;

import com.study.demo.service.CarService;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rong.xu
 */
@Data
public class CarFactory {

    private static Map<String, CarService> serviceMap = new HashMap<>();

    public static void putService(String type, CarService carService){
        serviceMap.put(type,carService);
    }

    public static CarService getServiceByType(String type){
        return serviceMap.get(type);
    }
}
