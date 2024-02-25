package FlashSale.main.java.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class User {
    private String userId;
    private String userName;
    private Address addressDetails;
    private List<String> dealIds;
}
