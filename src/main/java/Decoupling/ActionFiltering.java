package Decoupling;

public class ActionFiltering implements Filterr {
    @Override
    public String[] getRecommendatins(String movie) {
        return new String[]{"Italian Job","MI","MI3"};
    }
}
