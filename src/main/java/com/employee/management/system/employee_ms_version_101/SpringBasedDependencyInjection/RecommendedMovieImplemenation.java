package com.employee.management.system.employee_ms_version_101.SpringBasedDependencyInjection;

import Decoupling.RecommendedImplemenation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


// Making this as a bean via spring so that it will get selected
@Component
public class RecommendedMovieImplemenation {

    // Defining dependency as Filterr via spring
    @Autowired
    private Filterr filter;
    // private Filter contentFiltering; // manually injecting dependency



    // Injecting via Setter
    /*
    @Autowired
    @Qualifier("CF")
    public void setFilter(Filterr filter){
        this.filter = filter;
    }
    */




    // Constructor Injection (Autowiring + Injecting)
    public RecommendedMovieImplemenation(@Qualifier("CF") Filterr filter){
        this.filter = filter;
    }




    //public RecommendedMovieImplemenation(Filterr filter){
    //    this.filter = filter;
    //}

    public String[] recommendedMovie(String movie){
        System.out.println("Checking the filter names in usage : "+ filter+"\n");
        String[] resultMovies = filter.getRecommendatins(movie);

        return resultMovies;
    }
}
