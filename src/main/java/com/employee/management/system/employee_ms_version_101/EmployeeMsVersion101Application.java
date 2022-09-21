package com.employee.management.system.employee_ms_version_101;

import Decoupling.ActionFiltering;
import Decoupling.CartoonFiltering;
import Decoupling.RecommendedImplemenation;
import TightCoupling.RecommendersImplementation;
import com.employee.management.system.employee_ms_version_101.SpringBasedDependencyInjection.RecommendedMovieImplemenation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


import java.util.Arrays;

@SpringBootApplication
public class EmployeeMsVersion101Application {
	/*
	Spring Boot -> Spring Framework + Embedded Server

	TIGHT COUPLING :
	->  Two classes are dependent on each other
	->  One class has to be changed to some other responsibility you
    	cant really do it
    	EG:	RecommendationImplementation needs ContentFiltering class object
    		to access recommended movies.

	DECOUPLING/ LOOSE COUPLING :
	->	Independent Responsibilities



	// Inside SpringBasedDependencyInjection
	Spring Container -- Private Filter filter [AutoWired] -> @Primary Multifiltering on ContentFiltering
	-> Creates Instances @Componenet => @Autowiring - checks for the instances that are of type filter
	-> @Primary => RecommededMovieImplementation (Filter Multifiltering)
	-> @Qualifier => Given with the dependency
	Filter Multifiltering -> (dependency injected to) -> RecommendedMovieImplementation



	ANNOTATIONS :
	@Component => Creates the bean for Spring Container => Object Instance for that Class => Business Objects
	1) @Autowired => Injects Dependency
	2) Dependency Injecting by name for the Type (eg: private Filterr contentFiltering)
	3) @Primary   => Default Choice of Type Filter and injecting it as a dependency object
	4) @Qualifier => Giving identity to a bean (Qualifier trumps Primary)
	5) Constructor Injection



	*/

	public static void main(String[] args) {
		// Tight Coupling
		RecommendersImplementation recommendations = new RecommendersImplementation();
		String[] resultMovies = recommendations.recommendedMovie("Jakc Reacher");
		System.out.println(Arrays.toString(resultMovies));


		//SpringApplication.run(EmployeeMsVersion101Application.class, args);

		System.out.println("----------------------------------");

		// Decoupling/Loose Couple
		// Dependency Injection
		RecommendedImplemenation recommendObj = new RecommendedImplemenation((new CartoonFiltering()));
		RecommendedImplemenation recommendObj1 = new RecommendedImplemenation((new ActionFiltering()));

		String[] finalResultMovies = recommendObj.recommendedMovie("ET");

		System.out.println(Arrays.toString(finalResultMovies));
		System.out.println("----------------------------------");

		// Spring based Automanaging Dependencies
		ApplicationContext appContextObj = SpringApplication.run(EmployeeMsVersion101Application.class, args);


		// Using the appContext
		RecommendedMovieImplemenation recommeder3 = appContextObj.getBean(RecommendedMovieImplemenation.class);

		// Since we have defined @Component in ContentFiltering, that class became
		// a bean and thus it will get selected in recommededMovie()
		String[] finalResultMovie3 = recommeder3.recommendedMovie("Some Movie");
		System.out.println("recommender3 = "+ Arrays.toString(finalResultMovie3));

	}

}

// Any application -> Model -> Data Layer, Exclude -> Postman  View -> Web Layer, Controller -> Business Layer
// Web Layer, Business Layer, Data Layer
// (Presentation, Business Logic, Data Access)


// PRINCIPLES : Dependency Injection, Inversion of Control -> during run time

// Tight Coupling
/*
public class MovieRecommender {
	ContentBasedFilter filter = new ContentBasedFilter();
	//...
}

public class ContentBasedFilter {
    //...
 }

*/


// Loose Coupling

/*
interface Filter {
    //method declarations
}
public class ContentBasedFilter implements Filter {
    //implement interface methods
}
public class MovieRecommender {

    Filter filter;

    public MovieRecommender(Filter filter) {
        this.filter = filter;
    }

    //...

	public static void main(String[] args) {

		MovieRecommender recommender = new MovieRecommender(new ContentBasedFilter());
		//...
	}

}
*/

/*
Beans
Autowiring
Dependency injection
Inversion of Control
IoC container
Bean factory
Application context


@Component
class Arithmetic(){
    @Autowired
    private Operator operator;
    //...
}

@Component
class Addition implements Operator {

}

@Component
class Subtraction implements Operator {

}


 */

/*
@Bean
public class BookDB{
	private String bookId = "0";

	private  BookDBAD database = null;

	public BookDB(){

	}
}
*/




