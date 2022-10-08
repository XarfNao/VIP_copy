package extended_mitre.capec;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * This class represents a CAPEC relation object (nature attribute, CAPEC code (ID) of related CAPEC attack pattern, exclude IDs)
 * <p>
 * Objects can be put into database
 * <p>
 * It can create a CAPEC relation object from given parameters and return it
 *
 * @author Tomas Bozek (XarfNao)
 */
@Entity(name = "related_attack_pattern")
@Table(name="related_attack_pattern", schema = "mitre")
public class CAPECrelationObj {

    public CAPECrelationObj() { } // default constructor

    /**
     * Automatic ID
     */
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column
    protected String nature;
    @Transient
    protected String related_capec_id;
    @Column(name = "exclude_id")
    @CollectionTable(name = "rel_capec_exclude_ids", schema = "mitre")
    @ElementCollection(targetClass = String.class)
    protected List<String> exclude_ids;
    @ManyToOne
    protected CAPECobject capec;
    @ManyToOne
    protected CAPECobject related_capec;

    /**
     * Copies constructor
     *
     * @param nature            nature attribute
     * @param related_capec_id  CAPEC code (ID) of related CAPEC attack pattern
     * @param exclude_ids       exclude IDs
     */
    public CAPECrelationObj(String nature, String related_capec_id, List<String> exclude_ids) {

        this.nature = nature;
        this.related_capec_id = related_capec_id;
        this.exclude_ids = exclude_ids;

    }

    public String getRelated_capec_id() {
        return related_capec_id;
    }

    public void setRelated_capec(CAPECobject related_capec) {
        this.related_capec = related_capec;
    }

    public void setCapec(CAPECobject capec) {
        this.capec = capec;
    }

    ///**
    // * This method's purpose is to create a CAPEC relation object from given parameters and return it
    // *
    // * @return CAPEC relation object
    // */
    //public static CAPECrelationObj getInstance(String nature, String related_capec_id, List<String> exclude_ids) {

    //    return new CAPECrelationObj(nature, related_capec_id, exclude_ids);
    //}

    @Override
    public String toString() {
        return "CAPECrelationObj{" +
                "nature='" + nature + '\'' +
                ", related_capec_id='" + related_capec_id + '\'' +
                ", exclude_ids=" + exclude_ids +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CAPECrelationObj)) return false;
        CAPECrelationObj that = (CAPECrelationObj) o;
        return Objects.equals(nature, that.nature) && Objects.equals(related_capec_id, that.related_capec_id) && Objects.equals(exclude_ids, that.exclude_ids) && Objects.equals(capec, that.capec) && Objects.equals(related_capec, that.related_capec);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nature, related_capec_id, exclude_ids);
    }
}
