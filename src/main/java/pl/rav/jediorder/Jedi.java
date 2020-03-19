package pl.rav.jediorder;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Data
public class Jedi {

    @NotEmpty(message = "Jedi name is mandatory and cannot be empty")
    private String name;

    @NotEmpty(message="all Jedi features need to be set")
    private JediSet jediSet;


}
