package pl.rav.jediorder.orders;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pl.rav.jediorder.warrior.Warrior;
import pl.rav.jediorder.warrior.types.OrderName;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Map;

import static pl.rav.jediorder.warrior.types.Side.DARK;
import static pl.rav.jediorder.warrior.types.Side.LIGHT;

@Getter
@ToString
@AllArgsConstructor
//@NoArgsConstructor
public class Order {

    @NotEmpty(message = "order name cannot be empty")
    private OrderName name;

    @NotEmpty(message = "each order needs to have its insignia")
    private String insignia;

    private Map<String, Warrior> warriors;

    public boolean addWarrior(Warrior warrior) {
        if (!warriors.containsKey(warrior.getName())) {
            warriors.put(warrior.getName(), warrior);
            return true;
        }
        return false;
    }

}
