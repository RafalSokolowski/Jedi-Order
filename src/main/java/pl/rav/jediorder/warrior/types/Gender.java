package pl.rav.jediorder.warrior.types;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Gender {
    MALE("Male"),
    FEMALE("Female");
    private String desc;
}
