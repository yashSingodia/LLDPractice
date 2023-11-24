package Ecommerce;

import Ecommerce.repository.BuyerRepository;
import Ecommerce.repository.OrderRepository;
import Ecommerce.repository.PincodeServiceablityRepository;
import Ecommerce.repository.ProductRepository;

public class Main {

    public static void main(String[] args) {
        BuyerRepository buyerRepository = new BuyerRepository();
        OrderRepository orderRepository = new OrderRepository();
        ProductRepository productRepository = new ProductRepository();
        PincodeServiceablityRepository pincodeServiceablityRepository = new PincodeServiceablityRepository();

    }
}
