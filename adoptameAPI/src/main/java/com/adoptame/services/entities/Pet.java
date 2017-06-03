package com.adoptame.services.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "pet")
public class Pet implements Serializable{
	
	private static final long serialVersionUID = -1306873774567654340L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "birthdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthdate;
    @Column(name = "image")
    private String image;
    @Basic(optional = false)
    @Column(name = "sterilized")
    private boolean sterilized;
    @JoinTable(name = "pet_vaccine", joinColumns = {
        @JoinColumn(name = "pet_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "vaccine_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Vaccine> vaccineCollection;
    @OneToOne(mappedBy = "petId")
    private Adoption adoption;
    @OneToOne(mappedBy = "petId")
    private Post post;
    @JoinColumn(name = "breed_id", referencedColumnName = "id")
    @ManyToOne
    private Breed breed;
    @JoinColumn(name = "specie_id", referencedColumnName = "id")
    @ManyToOne
    private Specie specie;

    public Pet() {
    }

    public Pet(Integer id) {
        this.id = id;
    }

    public Pet(Integer id, boolean sterilized) {
        this.id = id;
        this.sterilized = sterilized;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean getSterilized() {
        return sterilized;
    }

    public void setSterilized(boolean sterilized) {
        this.sterilized = sterilized;
    }

    public Collection<Vaccine> getVaccineCollection() {
        return vaccineCollection;
    }

    public void setVaccineCollection(Collection<Vaccine> vaccineCollection) {
        this.vaccineCollection = vaccineCollection;
    }

    public Adoption getAdoption() {
        return adoption;
    }

    public void setAdoption(Adoption adoption) {
        this.adoption = adoption;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
    
    public Breed getBreed() {
		return breed;
	}

	public void setBreed(Breed breed) {
		this.breed = breed;
	}

	public Specie getSpecie() {
		return specie;
	}

	public void setSpecie(Specie specie) {
		this.specie = specie;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pet)) {
            return false;
        }
        Pet other = (Pet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.adoptame.services.entities.Pet[ id=" + id + " ]";
    }
}
