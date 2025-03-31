package sia.taco_cloud;

import lombok.Data;

@Data
public class Order {
    private String name;
    private String street;
    private String city;
    private String zip;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;
}
