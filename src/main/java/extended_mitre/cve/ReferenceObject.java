package extended_mitre.cve;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * This class represents a reference object which can be found in CVE object
 * <p>
 * Objects can be put into database and quickly updated
 * <p>
 * It can create a reference object from given parameters and return it
 *
 * @author Tomas Bozek (XarfNao)
 */
@Entity(name = "cve_reference")
@Table(name="cve_reference", schema = "mitre")
public class ReferenceObject {

    public ReferenceObject() { } // default constructor

    /**
     * Automatic ID
     */
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(length = 8191)
    protected String url;
    @Column(length = 8191)
    protected String name;
    protected String refsource;
    @Column(name = "tag")
    @CollectionTable(name = "ref_tags", schema = "mitre")
    @ElementCollection(targetClass = String.class)
    protected List<String> tags;
    @ManyToOne
    @JoinColumn(nullable = false)
    protected CVEobject cve;

    public void setCve_obj(CVEobject cve) {
        this.cve = cve;
    }

    /**
     * Copies constructor
     *
     * @param url       reference url
     * @param name      name of the reference
     * @param refsource refsource attribute
     * @param tags      tags of the reference
     */
    public ReferenceObject(String url, String name, String refsource, List<String> tags) {

        this.url = url;
        this.name = name;
        this.refsource = refsource;
        this.tags = tags;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRefsource() {
        return refsource;
    }

    public void setRefsource(String refsource) {
        this.refsource = refsource;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    ///**
    // * This method's purpose is to create a reference object from given parameters and return it
    // *
    // * @return reference object
    // */
    //public static ReferenceObject getInstance(String url, String name, String refsource, List<String> tags) {

    //    return new ReferenceObject(url, name, refsource, tags);
    //}

    @Override
    public String toString() {
        return "ReferenceObject{" +
                "url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", refsource='" + refsource + '\'' +
                ", tags=" + tags +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReferenceObject)) return false;
        ReferenceObject that = (ReferenceObject) o;
        return Objects.equals(url, that.url) && Objects.equals(name, that.name) && Objects.equals(refsource, that.refsource) && Objects.equals(tags, that.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, name, refsource, tags);
    }
}
