package com.employee.management.system.employee_ms_version_101.SpringBasedDependencyInjection;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary  // @Qualifier("MF")
public class MultiFiltering implements Filterr {

    @Override
    public String[] getRecommendatins(String movie) {
        return new String[]{"Ice Age", "Toy Story", "The Croods"};
    }
}
