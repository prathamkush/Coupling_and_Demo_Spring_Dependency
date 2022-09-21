package TightCoupling;

public class RecommendersImplementation {

    public String[] recommendedMovie(String movie){
        // Content Filtering
        ContentFiltering filter = new ContentFiltering();
        String[] filteredResult = filter.getRecommendations("Jack Reacher");

        return filteredResult;
    }
}
