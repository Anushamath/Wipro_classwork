package aopdemo.Aop;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
    	
    	ApplicationContext context = 
    			new AnnotationConfigApplicationContext(BeanConfig.class);
    	Checkout checkout = context.getBean(Checkout.class);
    	
    	ShoppingCart cart = context.getBean(ShoppingCart.class);
    	
    	 cart.checkout("checkout started");
    	// Call
         checkout.checkoutOrder("Checkout started");
         checkout.calculation(5);
    }

	
}