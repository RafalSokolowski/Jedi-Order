package pl.rav.jediorder;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class Jedi {

    @NotEmpty(message = "Jedi name is mandatory and cannot be empty")
    private String name;

//    @NotEmpty(message="all Jedi set need to be set")
//    private JediSet jediSet;

//    @NotEmpty(message="all Jedi features need to be set")
////    private JediFeature feature;
//    private List<String> features;

    @NotEmpty(message = "side is mandatory")
    private String side;
    @NotEmpty(message = "lightsaber color is mandatory")
    private String lightsaber;
    @NotEmpty(message = "strength is mandatory")
    private String strength; // docelowo zmienić na int z przedziału 1-1000
    @NotEmpty(message = "there needs to be any appearance:)")
    private String appearance;


}
