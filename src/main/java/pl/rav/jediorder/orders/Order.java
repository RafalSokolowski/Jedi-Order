package pl.rav.jediorder.orders;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pl.rav.jediorder.warrior.Warrior;
import pl.rav.jediorder.warrior.types.OrderName;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @NotEmpty(message = "order name cannot be empty")
    private OrderName name;

    @NotEmpty(message = "each order needs to have its insignia")
    private String insignia;

    private List<Warrior> warriors;

}
