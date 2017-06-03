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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "post")
public class Post implements Serializable{

	private static final long serialVersionUID = 7091251948219210630L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @Column(name = "active")
    private boolean active;
    @Column(name = "observations")
    private String observations;
    @Column(name = "visits")
    private Integer visits;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    @JsonIgnore
    private User user;
    @JoinColumn(name = "pet_id", referencedColumnName = "id")
    @OneToOne
    @JsonIgnore
    private Pet pet;

    public Post() {
    }

    
    
    public Post(Integer id, Date date, boolean active, String observations, Integer visits, User user, Pet pet) {
		super();
		this.id = id;
		this.date = date;
		this.active = active;
		this.observations = observations;
		this.visits = visits;
		this.user = user;
		this.pet = pet;
	}



	public Post(Integer id) {
        this.id = id;
    }

    public Post(Integer id, boolean active) {
        this.id = id;
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public Integer getVisits() {
        return visits;
    }

    public void setVisits(Integer visits) {
        this.visits = visits;
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
        if (!(object instanceof Post)) {
            return false;
        }
        Post other = (Post) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.adoptame.services.entities.Post[ id=" + id + " ]";
    }

}
