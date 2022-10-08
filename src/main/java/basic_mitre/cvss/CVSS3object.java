package basic_mitre.cvss;

import basic_mitre.cve.CVEobject;

import javax.persistence.*;
import java.util.Objects;

/**
 * This class represents a CVSS v3 object (Base score metrics, ...)
 * <p>
 * It can create a CVSS v3 (base metric v3) object from given parameters and return it
 * Objects can be put into database including quick updates
 *
 * @author Tomas Bozek (XarfNao)
 */
@Entity(name = "cvss3")
@Table(name="cvss3", schema = "mitre")
public class CVSS3object {

    public CVSS3object() { } // default constructor

    /**
     * Automatic ID
     */
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String version;
    protected String vector_string;
    protected String attack_vector;
    protected String attack_complexity;
    protected String privileges_required;
    protected String user_interaction;
    protected String scope;
    protected String confidentiality_impact;
    protected String integrity_impact;
    protected String availability_impact;
    protected double base_score_v3;
    protected String base_severity_v3;
    protected double exploitability_score_v3;
    protected double impact_score_v3;
    @OneToOne(mappedBy = "cvss_v3")
    protected CVEobject cve_obj;

    /**
     * Copies constructor
     *
     * @param version                 CVSS v3 version
     * @param vector_string           vector string
     * @param attack_vector           attack vector attribute
     * @param attack_complexity       attack complexity attribute
     * @param privileges_required     privileges required attribute
     * @param user_interaction        user interaction attribute
     * @param scope                   scope attribute
     * @param confidentiality_impact  confidentiality impact attribute
     * @param integrity_impact        integrity impact attribute
     * @param availability_impact     availability impact attribute
     * @param base_score_v3           base score given by CVSS v3 calculator
     * @param base_severity_v3        base severity
     * @param exploitability_score_v3 exploitability subscore given by CVSS v3 calculator
     * @param impact_score_v3         impact subscore given by CVSS v3 calculator
     */
    public CVSS3object(String version, String vector_string, String attack_vector, String attack_complexity,
                       String privileges_required, String user_interaction, String scope, String confidentiality_impact,
                       String integrity_impact, String availability_impact, double base_score_v3, String base_severity_v3,
                       double exploitability_score_v3, double impact_score_v3) {

        this.version = version;
        this.vector_string = vector_string;
        this.attack_vector = attack_vector;
        this.attack_complexity = attack_complexity;
        this.privileges_required = privileges_required;
        this.user_interaction = user_interaction;
        this.scope = scope;
        this.confidentiality_impact = confidentiality_impact;
        this.integrity_impact = integrity_impact;
        this.availability_impact = availability_impact;
        this.base_score_v3 = base_score_v3;
        this.base_severity_v3 = base_severity_v3;
        this.exploitability_score_v3 = exploitability_score_v3;
        this.impact_score_v3 = impact_score_v3;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVector_string() {
        return vector_string;
    }

    public void setVector_string(String vector_string) {
        this.vector_string = vector_string;
    }

    public String getAttack_vector() {
        return attack_vector;
    }

    public void setAttack_vector(String attack_vector) {
        this.attack_vector = attack_vector;
    }

    public String getAttack_complexity() {
        return attack_complexity;
    }

    public void setAttack_complexity(String attack_complexity) {
        this.attack_complexity = attack_complexity;
    }

    public String getPrivileges_required() {
        return privileges_required;
    }

    public void setPrivileges_required(String privileges_required) {
        this.privileges_required = privileges_required;
    }

    public String getUser_interaction() {
        return user_interaction;
    }

    public void setUser_interaction(String user_interaction) {
        this.user_interaction = user_interaction;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getConfidentiality_impact() {
        return confidentiality_impact;
    }

    public void setConfidentiality_impact(String confidentiality_impact) {
        this.confidentiality_impact = confidentiality_impact;
    }

    public String getIntegrity_impact() {
        return integrity_impact;
    }

    public void setIntegrity_impact(String integrity_impact) {
        this.integrity_impact = integrity_impact;
    }

    public String getAvailability_impact() {
        return availability_impact;
    }

    public void setAvailability_impact(String availability_impact) {
        this.availability_impact = availability_impact;
    }

    public double getBase_score_v3() {
        return base_score_v3;
    }

    public void setBase_score_v3(double base_score_v3) {
        this.base_score_v3 = base_score_v3;
    }

    public String getBase_severity_v3() {
        return base_severity_v3;
    }

    public void setBase_severity_v3(String base_severity_v3) {
        this.base_severity_v3 = base_severity_v3;
    }

    public double getExploitability_score_v3() {
        return exploitability_score_v3;
    }

    public void setExploitability_score_v3(double exploitability_score_v3) {
        this.exploitability_score_v3 = exploitability_score_v3;
    }

    public double getImpact_score_v3() {
        return impact_score_v3;
    }

    public void setImpact_score_v3(double impact_score_v3) {
        this.impact_score_v3 = impact_score_v3;
    }

    ///**
    // * This method's purpose is to create a CVSS v3 (base metric v3) object from given parameters and return it
    // *
    // * @return CVSS v3 (base metric v3) object
    // */
    //public static CVSS3object getInstance(String version, String vector_string, String attack_vector, String attack_complexity, String privileges_required,
    //                                      String user_interaction, String scope, String confidentiality_impact, String integrity_impact,
    //                                      String availability_impact, double base_score_v3, String base_severity_v3, double exploitability_score_v3,
    //                                      double impact_score_v3) {

    //    return new CVSS3object(version, vector_string, attack_vector, attack_complexity, privileges_required, user_interaction, scope,
    //            confidentiality_impact, integrity_impact, availability_impact, base_score_v3, base_severity_v3, exploitability_score_v3,
    //            impact_score_v3);
    //}

    @Override
    public String toString() {
        return "CVSS3object{" +
                "version='" + version + '\'' +
                ", vector_string='" + vector_string + '\'' +
                ", attack_vector='" + attack_vector + '\'' +
                ", attack_complexity='" + attack_complexity + '\'' +
                ", privileges_required='" + privileges_required + '\'' +
                ", user_interaction='" + user_interaction + '\'' +
                ", scope='" + scope + '\'' +
                ", confidentiality_impact='" + confidentiality_impact + '\'' +
                ", integrity_impact='" + integrity_impact + '\'' +
                ", availability_impact='" + availability_impact + '\'' +
                ", base_score_v3='" + base_score_v3 + '\'' +
                ", base_severity_v3='" + base_severity_v3 + '\'' +
                ", exploitability_score_v3='" + exploitability_score_v3 + '\'' +
                ", impact_score_v3='" + impact_score_v3 + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CVSS3object)) return false;
        CVSS3object that = (CVSS3object) o;
        return Double.compare(that.base_score_v3, base_score_v3) == 0 && Double.compare(that.exploitability_score_v3, exploitability_score_v3) == 0 && Double.compare(that.impact_score_v3, impact_score_v3) == 0 && Objects.equals(version, that.version) && Objects.equals(vector_string, that.vector_string) && Objects.equals(attack_vector, that.attack_vector) && Objects.equals(attack_complexity, that.attack_complexity) && Objects.equals(privileges_required, that.privileges_required) && Objects.equals(user_interaction, that.user_interaction) && Objects.equals(scope, that.scope) && Objects.equals(confidentiality_impact, that.confidentiality_impact) && Objects.equals(integrity_impact, that.integrity_impact) && Objects.equals(availability_impact, that.availability_impact) && Objects.equals(base_severity_v3, that.base_severity_v3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(version, vector_string, attack_vector, attack_complexity, privileges_required, user_interaction, scope, confidentiality_impact, integrity_impact, availability_impact, base_score_v3, base_severity_v3, exploitability_score_v3, impact_score_v3);
    }
}
