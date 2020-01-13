package tacos;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

@Data
//@Entity
//@Table(name = "Taco_Order")
public class Order {

    //    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotBlank(message = "Id is required")
    private Long id;

    @NotBlank(message = "placeAt is required")
    private Date placedAt;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Street is required")
    private String street;

    @NotBlank(message = "City is required")
    private String city;

    @NotBlank(message = "State is required")
    private String state;

    @NotBlank(message = "Zip is required")
    private String zip;

    @CreditCardNumber(message = "not a valid credit card number")
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$", message = "Must be format MM/YY")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "invalid CVV")
    private String ccCVV;

    //    @ManyToMany(targetEntity = Taco.class)
    private List<Taco> tacos;

//    @PrePersist
//    void placeAt() {
//        placedAt = new Date();
//    }

}
