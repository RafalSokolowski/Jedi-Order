package pl.rav.jediorder;

import lombok.*;

import javax.validation.constraints.*;
import java.util.List;

@Data
public class Jedi {

    @NotEmpty(message = "Jedi name is mandatory and cannot be empty")
    private String name;

    @NotEmpty(message = "side is mandatory")
    private String side;

    @NotEmpty(message = "lightsaber color is mandatory")
    private String lightsaber;

    @Min(value=1, message = "strength needs to be greater than 1")
    @Max(value=1000, message = "strength needs to be lower than 1000")
    @NotNull(message = "strength cannot be empty")
    private int strength; // docelowo zmienić na int z przedziału 1-1000

    @NotEmpty(message = "there need to be any appearance:)")
    private String appearance;

    @NotEmpty(message = "Your mighty Jedi needs to belong to Order")
    private String order;

}
