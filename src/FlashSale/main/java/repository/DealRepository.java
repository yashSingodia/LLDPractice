package FlashSale.main.java.repository;

import exceptions.*;
import models.Deal;
import models.DealStatus;

import java.util.HashMap;

public class DealRepository {
    private final HashMap<String, Deal> dealsMap;

    public DealRepository() {
        this.dealsMap = new HashMap<>();
    }

    // create deal
    public boolean createDeal(String dealId, Deal deal) throws DealAlreadyPresentException {
        // update details from productService on quantity
        if (dealsMap.containsKey(dealId)) {
            throw new DealAlreadyPresentException(String.format("Deal %s is already present", dealId));
        }
        deal.setDealStatus(DealStatus.IN_PROGRESS);
        dealsMap.put(dealId, deal);
        return true;
    }

    public Deal getDeal(String dealId) throws DealNotFoundException, DealFinishedException {

        if (!dealsMap.containsKey(dealId)) {
            throw new DealNotFoundException(String.format("Deal %s not found", dealId));
        }
        Deal deal = dealsMap.get(dealId);
        if (System.currentTimeMillis() > deal.getEndTimeStamp()) {
            deal.setDealStatus(DealStatus.FINISHED);
            throw new DealFinishedException("");
        }
        return deal;
    }

    private boolean updateDealsMap(String dealid, Deal deal) {
        dealsMap.put(dealid, deal);
        return true;
    }

    public boolean endDeal(String dealId) throws DealNotFoundException, DealFinishedException {
        Deal deal = getDeal(dealId);
        deal.setDealStatus(DealStatus.FINISHED);

        return updateDealsMap(dealId, deal);
    }


    // change deal configs
    public boolean updateQuantity(String dealId, int updatedQuantity) throws DealNotFoundException, DealFinishedException {
        // update details from productService on quantity
        Deal deal = getDeal(dealId);

        if (DealStatus.IN_PROGRESS.equals(deal.getDealStatus())) {
            deal.setQuantity(updatedQuantity);
        }

        return updateDealsMap(dealId, deal);
    }

    public boolean updateEndTime(String dealId, long updatedTimestamp) throws IncorrectTimestampException, DealNotFoundException, DealFinishedException {

        if (updatedTimestamp < System.currentTimeMillis()) {
            throw new IncorrectTimestampException(String.format("timestamp provider for deal %s is not valid", dealId));
        }

        Deal deal = getDeal(dealId);

        if (DealStatus.IN_PROGRESS.equals(deal.getDealStatus())) {
            deal.setEndTimeStamp(updatedTimestamp);
        }

        return updateDealsMap(dealId, deal);
    }

    // delete a deal

    public void validateDeal(String dealId) throws DealFinishedException, DealNotFoundException, ItemsExhaustedException {
        Deal deal = getDeal(dealId);
        if (DealStatus.FINISHED == deal.getDealStatus()) {
            throw new DealFinishedException(String.format(""));
        }

        if (deal.getQuantity() == 0) {
            throw new ItemsExhaustedException(String.format(""));
        }
    }

    public void decreaseQuantity(String dealId) throws DealNotFoundException, DealFinishedException {
        Deal deal = getDeal(dealId);
        updateQuantity(dealId, deal.getQuantity() - 1);
    }
}
