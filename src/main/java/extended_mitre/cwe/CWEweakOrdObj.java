package extended_mitre.cwe;

import javax.persistence.*;
import java.util.Objects;

/**
 * This class represents a CWE weakness ordinality object (ordinality attribute, description attribute)
 * <p>
 * Objects can be put into database
 * <p>
 * It can create a CWE weakness ordinality object from given parameters and return it
 *
 * @author Tomas Bozek (XarfNao)
 */
@Entity
@Table(name="cwe_weakness_ordinality", schema = "mitre")
public class CWEweakOrdObj {

    public CWEweakOrdObj() {} // default constructor

    /**
     * Automatic ID
     */
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String ordinality;
    @Column(length = 8191)
    protected String description;
    @ManyToOne
    protected CWEobject cwe;

    /**
     * Copies constructor
     *
     * @param ordinality  ordinality attribute
     * @param description description attribute
     */
    public CWEweakOrdObj(String ordinality, String description) {

        this.ordinality = ordinality;
        this.description = description;

    }

    public void setCwe(CWEobject cwe) {
        this.cwe = cwe;
    }

    ///**
    // * This method's purpose is to create a CWE weakness ordinality object from given parameters and return it
    // *
    // * @return CWE weakness ordinality object
    // */
    //public static CWEweakOrdObj getInstance(String ordinality, String description) {

    //    return new CWEweakOrdObj(ordinality, description);
    //}

    @Override
    public String toString() {
        return "CWEweakOrdObj{" +
                "ordinality='" + ordinality + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CWEweakOrdObj)) return false;
        CWEweakOrdObj that = (CWEweakOrdObj) o;
        return Objects.equals(ordinality, that.ordinality) && Objects.equals(description, that.description) && Objects.equals(cwe, that.cwe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ordinality, description);
    }
}
