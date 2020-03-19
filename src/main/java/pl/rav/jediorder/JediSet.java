package pl.rav.jediorder;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;


@Data
public class JediSet {

    @NotBlank(message = "set ID cannot be null, empty or whitespace")
    private final String setID;

    private final Type lightsaber;

    @Size(min = 1, max = 1000, message = "strength must be between 1 and 1000")
    private final int strength;

    private final Side side;


    public enum Type { BLUE, RED, NOP }
    public enum Side { DARK, LIGHT }

}
