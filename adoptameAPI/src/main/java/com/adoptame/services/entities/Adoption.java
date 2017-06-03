package com.adoptame.services.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "adoption")
public class Adoption implements Serializable {

	private static final long serialVersionUID = -485245347206433532L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "active")
    private boolean active;
    @Column(name = "adoptiondate")
    private Date adoptionDate;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    @JsonIgnore
    private User user;

	@JoinColumn(name = "pet_id", referencedColumnName = "id")
    @OneToOne
    private Pet pet;

    public Adoption() {
    }

    public Adoption(Integer id) {
        this.id = id;
    }

    public Adoption(Integer id, boolean active) {
        this.id = id;
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }    

    public Date getAdoptionDate() {
		return adoptionDate;
	}

	public void setAdoptionDate(Date adoptionDate) {
		this.adoptionDate = adoptionDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

    public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
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
        if (!(object instanceof Adoption)) {
            return false;
        }
        Adoption other = (Adoption) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.adoptame.services.entities.Adoption[ id=" + id + " ]";
    }
    
}