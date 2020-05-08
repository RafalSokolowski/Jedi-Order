package pl.rav.jediorder.warrior.types;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Gender {
    MALE("Male"),
    FEMALE("Female");
    private String desc;
}
