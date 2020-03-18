package pl.rav.jediorder;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class JediIngredient {

    private final String id;
    private final String name;
    private final Type lightsaber;
    private final int strength;
    private final Side side;

    public enum Type {
        BLUE, RED, YELLOW, NOP
    }

    public enum Side {
        DARK, LIGHT
    }
}
