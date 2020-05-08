package pl.rav.jediorder.orders;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import pl.rav.jediorder.warrior.Warrior;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@ToString
@AllArgsConstructor
public class Order {

    @NotEmpty(message = "order name cannot be empty")
    private String name;

    @NotEmpty(message = "each order needs to have its insignia")
    private String insignia;

    private List<Warrior> warriors;

}
