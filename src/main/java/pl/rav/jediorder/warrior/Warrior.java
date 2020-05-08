package pl.rav.jediorder.warrior;

import lombok.*;
import pl.rav.jediorder.orders.Order;
import pl.rav.jediorder.warrior.types.*;


import javax.validation.constraints.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Warrior {

    private int id;             // for databases
//    private LocalDate created;  // for databases

    @NotEmpty(message = "Jedi name is mandatory and cannot be empty")
    private String name;

    @NotEmpty(message = "side is mandatory")
    private Side side;

    @NotEmpty(message = "Your mighty Jedi needs to belong to Order")
    private Order order;

    @NotEmpty(message = "Grade cannot be empty")
    private Grade grade;

    @NotEmpty(message = "lightsaber color is mandatory")
    private Lightsaber lightsaber;

    @Min(value = 1, message = "strength needs to be greater than 1")
    @Max(value = 1000, message = "strength needs to be lower than 1000")
    @NotNull(message = "strength cannot be empty")
    private int strength; // docelowo zmienić na int z przedziału 1-1000

    @NotEmpty(message = "there need to be any appearance:)")
    private Appearance appearance;

    @NotEmpty(message = "home world can not be empty")
    private Planet homeWorld;

    @NotEmpty(message = "species can not be empty")
    private Species species;

    @NotEmpty(message = "gender can not be empty")
    private Gender gender;

//    private String[] cybernetics;
//
//    @NotEmpty(message = "clan can not be empty")
//    private Clan clan;

    private Warrior master;

}
