package Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Room {
    private int id;
    private int hotelId;
    private String number;
    private int typeId;
    private int bedCount;
}