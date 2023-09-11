package pl.polsl.lotawiec.robert.annotations;
import java.lang.annotation.*;

/**
 * Contains basic data about the algorithm
 * @author Robert Lotawiec
 * @version 1.2
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ProgramDocumentation {
    /**
    * @return Short name of the algorithm
    */
    String abbreviation();
    
    /**
    * @return Full name of the algorithm
    */
    String fullName();
    
    /**
    * @return Program publish year
    */
    int publishedYear();
    
    /**
    * @return Program's allowed characters for encoding in Base64
    */
    String allowedCharacters() default "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+_";
}