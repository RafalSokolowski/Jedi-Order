package pl.rav.jediorder.warrior.types;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Grade {
    NOVICE("Novice"),
    PADAWAN("Padawan"),
    ADEPT("Adept"),
    MASTER("Master"),
    G_MASTER("Grand Master");
    private String desc;
}