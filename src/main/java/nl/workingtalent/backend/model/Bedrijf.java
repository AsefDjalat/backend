package nl.workingtalent.backend.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Bedrijf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 100, nullable = false)
    private String naamBedrijf;

    @Column(length = 100, nullable = false)
    private String locatie;

    @Column(length = 155)
    private String branche;

    @Column(length = 254)
    private String bio;
    
    @OneToMany(mappedBy = "bedrijf", cascade = CascadeType.ALL)
    private List<Vacature> vacatures;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNaamBedrijf() {
        return naamBedrijf;
    }

    public void setNaamBedrijf(String naamBedrijf) {
        this.naamBedrijf = naamBedrijf;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public String getBranche() {
        return branche;
    }

    public void setBranche(String branche) {
        this.branche = branche;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
