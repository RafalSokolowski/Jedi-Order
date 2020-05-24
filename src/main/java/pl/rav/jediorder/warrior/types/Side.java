package pl.rav.jediorder.warrior.types;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Side {
    LIGHT("Light Side"),
    DARK("Dark Side");
    private String desc;
}
