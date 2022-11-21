package rs.ftn.uns.btb.core.blood;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import rs.ftn.uns.btb.core.blood.interfaces.BloodType;
import rs.ftn.uns.btb.core.center.Center;

import javax.persistence.*;

@Entity
@Table(name="blood")
@Getter @Setter
public class Blood {
    // Nesretno ime? Blood -> Inventory ili Bank?

    /*
        BLOOD_TYPE  |   QUANTITY    |   CENTER_ID?
        -------------------------------------------
            A+      |       1.4     |       1
        -------------------------------------------
            B       |       0.2     |       1
        -------------------------------------------
            O       |       0.4     |       2
     */

    @Id
    @Column(name = "TYPE", unique = true, nullable = false)
    private BloodType type;

    @Column(name = "QUANTITY", nullable = false)
    private Double quantity;

    // Centar u kom se nalazi
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Center center;

    public Blood() {}
}
