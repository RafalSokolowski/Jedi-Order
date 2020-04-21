package pl.rav.jediorder;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class JediFeature {

    @NotBlank(message = "ID set cannot be null, empty or whitespace")
    private final String id;

    @NotBlank(message = "Name set cannot be null, empty or whitespace")
    private final String name;

    private final Feature feature;

    public enum Feature {
        SIDE, LIGHTSABER, APPEARANCE, ORDER
    }

}
