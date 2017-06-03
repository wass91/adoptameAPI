package com.adoptame.services.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    @JsonIgnore
    private List<Vaccine> vaccineCollection;
    @OneToOne(mappedBy = "pet")
    private Adoption adoption;
    @OneToOne(mappedBy = "pet")
    @JsonIgnore
    private Post post;
    @JoinColumn(name = "breed_id", referencedColumnName = "id")
    @ManyToOne
    @JsonIgnore
    private Breed breed;
    @JoinColumn(name = "specie_id", referencedColumnName = "id")
    @ManyToOne
    @JsonIgnore
    private Specie specie;
    @OneToMany(mappedBy = "pet")
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonIgnore
    private List<Postulation> postulations;

    public Pet() {
    }
    
    

    public Pet(Integer id, Date birthdate, String image, boolean sterilized, List<Vaccine> vaccineCollection,
			Adoption adoption, Post post, Breed breed, Specie specie) {
		super();
		this.id = id;
		this.birthdate = birthdate;
		this.image = image;
		this.sterilized = sterilized;
		this.vaccineCollection = vaccineCollection;
		this.adoption = adoption;
		this.post = post;
		this.breed = breed;
		this.specie = specie;
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

    public List<Vaccine> getVaccineCollection() {
        return vaccineCollection;
    }

    public void setVaccineCollection(List<Vaccine> vaccineCollection) {
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
	

	public List<Postulation> getPostulations() {
		return postulations;
	}



	public void setPostulations(List<Postulation> postulations) {
		this.postulations = postulations;
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
