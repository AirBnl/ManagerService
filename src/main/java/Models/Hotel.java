package Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Hotel {
    private int id;
    private String name;
    private int managerId;
    private int countryId;
}
