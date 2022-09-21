package com.employee.management.system.employee_ms_version_101.SpringBasedDependencyInjection;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// Making this class - ContentFiltering as a bean
@Component
@Qualifier("CF")
public class ContentFiltering implements Filterr {
    @Override
    public String[] getRecommendatins(String movie) {
        return new String[]{"Italian Job","MI","MI3"};
    }
}
