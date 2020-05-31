package pl.rav.jediorder.support;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class RequestToSwapiSEARCH {

    @NotEmpty
    private String requestSEARCH;

}
