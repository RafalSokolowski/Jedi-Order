package pl.rav.jediorder;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class JediFeature {

    @NotBlank(message = "ID set cannot be null, empty or whitespace")
    private final String id;

    @NotBlank(message = "Name set cannot be null, empty or whitespace")
    private final String name;

    private final Feature feature;

    public enum Feature {
        SIDE, LIGHTSABER, STRENGTH, APPEARANCE
    }

//    @Size(min = 1, max = 1000, message = "strength must be between 1 and 1000")
//    private final int strength;


}
