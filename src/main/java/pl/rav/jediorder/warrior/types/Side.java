package pl.rav.jediorder.warrior.types;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Side {
    LIGHT("Light Side"),
    DARK("Dark Side");
    private String desc;
}
