package pl.rav.jediorder.warrior;

import lombok.*;
import pl.rav.jediorder.orders.Order;
import pl.rav.jediorder.support.Util;
import pl.rav.jediorder.warrior.types.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Warrior {

    private int id;

    //    @NotEmpty(message = "Jedi name is mandatory and cannot be empty")
    private String name;

    //    @NotEmpty(message = "side is mandatory")
    private Side side;

    //    @NotEmpty(message = "Your mighty Jedi needs to belong to Order")
    private OrderName order;

    //    @NotEmpty(message = "Grade cannot be empty")
    private Grade grade;

    //    @NotEmpty(message = "lightsaber color is mandatory")
    private Lightsaber lightsaber;

    //    @Min(value = 1, message = "strength needs to be greater than 1")
//    @Max(value = 1000, message = "strength needs to be lower than 1000")
//    @NotNull(message = "strength cannot be empty")
    private Integer strength;   // to make a placeholder for HTML works :)

    //    @NotEmpty(message = "there need to be any appearance:)")
    private Appearance appearance;

    //    @NotEmpty(message = "home world can not be empty")
    private Planet homeWorld;

    //    @NotEmpty(message = "species can not be empty")
    private Species species;

    //    @NotEmpty(message = "gender can not be empty")
    private Gender gender;

//    private String[] cybernetics;
//
//    @NotEmpty(message = "clan can not be empty")
//    private Clan clan;

    private Master master;

//    public Warrior() {
//        Jedi.getJedi().put(this.name,this);
//    }

    public String string() {
        StringBuilder sb = new StringBuilder();
        sb.append("id =         ").append(ifNullRedElseBlue(id)).append("\n");
        sb.append("name =       ").append(ifNullRedElseBlue(name)).append("\n");
        sb.append("side =       ").append(ifNullRedElseBlue(side)).append("\n");
        sb.append("order =      ").append(ifNullRedElseBlue(order)).append("\n");
        sb.append("grade =      ").append(ifNullRedElseBlue(grade)).append("\n");
        sb.append("lightsaber = ").append(ifNullRedElseBlue(lightsaber)).append("\n");
        sb.append("strength =   ").append(ifNullRedElseBlue(strength)).append("\n");
        sb.append("appearance = ").append(ifNullRedElseBlue(appearance)).append("\n");
        sb.append("homeWorld =  ").append(ifNullRedElseBlue(homeWorld)).append("\n");
        sb.append("species =    ").append(ifNullRedElseBlue(species)).append("\n");
        sb.append("gender =     ").append(ifNullRedElseBlue(gender)).append("\n");
        sb.append("master =     ").append(ifNullRedElseBlue(master)).append("\n");
        return sb.toString();
    }

    private String ifNullRedElseBlue(Object s) {
        if (s == null) return Util.RED + "null" + Util.RESET;
        if ("0".equals(s.toString())) return Util.RED + "0" + Util.RESET;
        if ("".equals(s.toString())) return Util.RED + "empty" + Util.RESET;
        return Util.BLUE + s + Util.RESET;
    }




}
