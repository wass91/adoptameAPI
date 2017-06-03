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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "postulation")
public class Postulation implements Serializable {

	private static final long serialVersionUID = -4115937695454842486L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "active")
    private boolean active;
    @Column(name = "postulationdate")
    private Date postulationDate;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    @JsonIgnore
    private User user;

	@JoinColumn(name = "pet_id", referencedColumnName = "id")
    @ManyToOne
    private Pet pet;

    public Postulation() {
    }

    
    
    public Postulation(Integer id, boolean active, Date adoptionDate, User user, Pet pet) {
		super();
		this.id = id;
		this.active = active;
		this.postulationDate = adoptionDate;
		this.user = user;
		this.pet = pet;
	}



	public Postulation(Integer id) {
        this.id = id;
    }

    public Postulation(Integer id, boolean active) {
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
	
	public Date getPostulationDate() {
		return postulationDate;
	}

	public void setPostulationDate(Date postulationDate) {
		this.postulationDate = postulationDate;
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
        if (!(object instanceof Postulation)) {
            return false;
        }
        Postulation other = (Postulation) object;
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