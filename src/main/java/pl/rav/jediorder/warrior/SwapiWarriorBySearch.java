package pl.rav.jediorder.warrior;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.rav.jediorder.support.ValidateRequestToSwapi;

@Getter
@Setter
@ToString
public class SwapiWarriorBySearch {

    private int count;
    private String next;
    private String previous;
    private SwapiWarriorByID[] results;

}
