package FlashSale.main.java.service;

import exceptions.*;
import models.Deal;
import models.Order;
import models.Product;
import repository.DealRepository;

public class DealService {

    private final DealRepository dealRepository;
    private final UserService userService;
    private final PaymentService paymentService;
    private final ProductService productService;

    private final OrderService orderService;

    public DealService(DealRepository dealRepository, UserService userService, PaymentService paymentService, ProductService productService, OrderService orderService) {
        this.dealRepository = dealRepository;
        this.userService = userService;
        this.paymentService = paymentService;
        this.productService = productService;
        this.orderService = orderService;
    }

    public void createDeal(String dealId, Deal deal) throws DealAlreadyPresentException {
        dealRepository.createDeal(dealId, deal);
    }

    public Deal getDeal(String dealId) throws DealNotFoundException, DealFinishedException {
        return dealRepository.getDeal(dealId);
    }


    public void updateQuantity(String dealId, int updatedQuantity) throws DealNotFoundException, DealFinishedException {
        dealRepository.updateQuantity(dealId, updatedQuantity);
    }

    public void decreaseQuantity(String dealId, String productId) throws DealNotFoundException, DealFinishedException, ProductNotFoundException {

        dealRepository.decreaseQuantity(dealId);
        productService.decreaseQuantity(productId);
    }

    public void updateEndtime(String dealId, long updatedTime) throws IncorrectTimestampException, DealNotFoundException, DealFinishedException {
        dealRepository.updateEndTime(dealId, updatedTime);
    }

    public void checkout(String userId, String dealId, String productId) throws UserAlreadClaimedException, ItemsExhaustedException, DealNotFoundException, DealFinishedException, PaymentFailedException, ProductNotFoundException, UserNotFoundException {

        // if deal is active and quantity is greater than 1
        // if user has already availed this deal

        dealRepository.validateDeal(dealId);
        if (!userService.validateUserForDeal(userId, dealId)) {
            throw new UserAlreadClaimedException("");
        }

            // Payment
        Product product = productService.getProduct(productId);
        if (!paymentService.payAmount(product.getPrice())) {
            throw new PaymentFailedException(String.format(""));
        }

        synchronized (this) {
            decreaseQuantity(dealId, productId);
            userService.addDealForUser(userId, dealId);
        }

        // invoice
        boolean invoice = orderService.generateInvoice();
    }


    public boolean endDeal(String dealId) throws DealNotFoundException, DealFinishedException {
        return dealRepository.endDeal(dealId);
    }

}
