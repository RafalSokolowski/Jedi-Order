package pl.rav.jediorder.warrior.types;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderName {
    REPUBLIC("Grand Galactic Army of the Republic"),
    EMPIRE("Palpatine's New Order (Galactic Empire)");
    private String desc;
}
