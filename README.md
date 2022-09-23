Spring Boot => Spring Framework + Embedded Server


Tight Coupling

=> Two Classes are dependent on each other
=> One class has to be changed to some other responsibility you can’t really do it

Decoupling/Loose Coupling

=> Independent Responsibilities


Spring Container =>  Private Filter filter [AutoWired] => @Primary MultiFiltering on ContentFiltering

=> Creates Instances @Component
=> @AutoWiring Filter => It Check for the instances that are of type Filter
=> @Primary => RecommendedMovieImplementations(Filter Multifiltering)


Annotations
——————
@Component => Creates the bean for Spring Container =>Object Instance for that class => Business Objects

Dependency Injection
———————————
1. @Autowired => Injects dependency => Only For Single Bean
2. @Primary => Default Choice of Type and injecting it as dependency object
3. Dependency Injection By Name for the Type
4. @Qualifier =>  Giving some identity, this also overwrites the default choice of @Primary
   Constructor Injection

Types of Dependency Injections

Constructor Injection  
——————————-
=> Inside the constructor(Filter filter)
@Autowired
public RecommendedMovieImpmenetation(@Qualifier("CF") Filter filter){
this.filter = filter;
}


Setter Injection
—————————
=> By using setter method
@Autowired
@Qualifier("CF")
public void setFilter(Filter filter) {
this.filter = filter;
}


Field Injection
—————————
=> During the field representation
=> @Autowired
private Filter filter;


-------------------------------------


BEAN SCOPES :
-> Singelton, Prototype, Request, Session, Application, WebSocket

Gang of Four Singleton