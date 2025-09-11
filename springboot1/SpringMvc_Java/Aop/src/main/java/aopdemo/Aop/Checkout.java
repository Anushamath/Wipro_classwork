package aopdemo.Aop;

import org.springframework.stereotype.Component;

@Component
public class Checkout {
    
    public void checkoutOrder(String status) {
        System.out.println("Order process has started... " + status);
    }
    
    public int calculation(int x) {
        int y = x + 1;
        return y;
    }
	

}