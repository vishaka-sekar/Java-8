import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StreamAndPredicate {
    public static void main(String args[]) {

        List<Integer> values = new ArrayList<>(Arrays.asList(1,2,4,5,7));
        // Print all elements
        System.out.println("All Elements");
        printElements(values, i -> true);
        System.out.println("Total of All elements: " +totalElements(values, i->true) );


        //Print odd elements
        System.out.println("Odd Elements");
        printElements(values, i->i%2 !=0);
        System.out.println("Total of odd numbers: "+totalElements(values, i -> i % 2 !=0) );


        //Filtering only even integers in a list
        // using Stream API and Predicate
        System.out.println("Even Elements");
        printElements(values , i -> i % 2 ==0);
        System.out.println("Total of even numbers: "+totalElements(values, i-> i %2 == 0));





    }

    /**
     * @param : takes 2 inputs: List of integers, and a condition
     ** @param condition uses dependency injection to specify a condition at runtime
     * **/
    public static void printElements(List<Integer> list , Predicate<Integer> condition){
        list.stream()
                .filter(condition)
                .forEach(i -> System.out.println(i));
    }


    public static int totalElements(List<Integer> list, Predicate<Integer> condition){

        return list.stream()
                .filter(condition)
                .reduce(0,Math::addExact);
    }


}