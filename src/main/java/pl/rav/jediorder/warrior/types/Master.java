package pl.rav.jediorder.warrior.types;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Master {
    M_YODA("Master Yoda"),
    M_VADER("Darth Vader"),
    M_SIDIOUS("Darth Sidious");

    private String desc;
}
