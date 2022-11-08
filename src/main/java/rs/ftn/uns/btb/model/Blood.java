package rs.ftn.uns.btb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TYPE", unique = true, nullable = false)
    private String type;    // TODO: String -> ENUM ?

    @Column(name = "QUANTITY", nullable = false)
    private Double quantity;

    // Centar u kom se nalazi
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Center center;

    public Blood() {}
}
