package com.adoptame.services.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "specie")
public class Specie implements Serializable{

	private static final long serialVersionUID = 6873081119016291212L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "specie")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    private List<Breed> breedCollection;
	@OneToMany(mappedBy = "specie")
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonIgnore
    private List<Pet> petCollection;

    public Specie() {
    }

    public Specie(Integer id) {
        this.id = id;
    }

    public Specie(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pet> getPetCollection() {
        return petCollection;
    }

    public void setPetCollection(List<Pet> petCollection) {
        this.petCollection = petCollection;
    }
    
    public List<Breed> getBreedCollection() {
		return breedCollection;
	}

	public void setBreedCollection(List<Breed> breedCollection) {
		this.breedCollection = breedCollection;
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
        if (!(object instanceof Specie)) {
            return false;
        }
        Specie other = (Specie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.adoptame.services.entities.Specie[ id=" + id + " ]";
    }

}
