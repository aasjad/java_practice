package com.ecommerce;

import com.ecommerce.exception.EcommerceException;
import com.ecommerce.model.Order;
import com.ecommerce.model.Product;
import com.ecommerce.service.OrderService;

public class EcommerceApp {
    public static void main(String[] args) {
        OrderService service = new OrderService();

        Product product1 = new Product("P1001", "Wireless Mouse", 25.00, 5);
        Product product2 = new Product("P1002", "Mechanical Keyboard", 80.00, 0);
        service.addProduct(product1);
        service.addProduct(product2);

        Order order1 = new Order("O1001", "P1001", 1, 25.00, true, 100.00, false);
        Order order2 = new Order("O1002", "P1002", 1, 80.00, true, 100.00, false);
        Order order3 = new Order("O1003", "P1001", 1, 30.00, true, 100.00, false);
        Order order4 = new Order("O1004", "P1001", 1, 25.00, false, 100.00, false);
        Order order5 = new Order("O1005", "P1001", 1, 25.00, true, 10.00, false);
        Order order6 = new Order("O1006", "P1001", 1, 25.00, true, 100.00, true);

        service.addOrder(order1);
        service.addOrder(order2);
        service.addOrder(order3);
        service.addOrder(order4);
        service.addOrder(order5);
        service.addOrder(order6);

        processOrder(service, "O1001");
        processOrder(service, "O1002");
        processOrder(service, "O1003");
        processOrder(service, "O1004");
        processOrder(service, "O1005");
        processOrder(service, "O1007");
    }

    private static void processOrder(OrderService service, String orderId) {
        try {
            service.processOrder(orderId);
            System.out.println("Order processed: " + orderId);
        } catch (Exception ex) {
            System.err.println("Order failed: " + ex.getMessage());
            if (ex instanceof EcommerceException) {
                System.err.println("Error code: " + ((EcommerceException) ex).getErrorCode());
            }
        }
    }
}


/*cd /d C:\MCL\Java\java_practice\ecommerce_app\src
javac com\ecommerce\exception\*.java com\ecommerce\model\*.java com\ecommerce\service\OrderService.java com\ecommerce\EcommerceApp.java
java com.ecommerce.EcommerceApp */