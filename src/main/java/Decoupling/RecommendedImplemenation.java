package Decoupling;

import TightCoupling.RecommendersImplementation;


public class RecommendedImplemenation {
    public Filterr filter;

    public RecommendedImplemenation(Filterr filter){
        super();
        this.filter = filter;
    }

    public String[] recommendedMovie(String movie){
        System.out.println("Checking the filter names in usage : "+ filter+"\n");
        String[] resultMovies = filter.getRecommendatins(movie);

        return resultMovies;
    }
}
