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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class User implements Serializable{
	private static final long serialVersionUID = -1421867814364883320L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Column(name = "names")
    private String names;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "password")
    private String password;
//    @Basic(optional = false)
    @Column(name = "phone")
    private String phone;
    @Column(name = "birthdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthdate;
//    @Basic(optional = false)
    @Column(name = "active")
    private boolean active;
    @ManyToMany(mappedBy = "usersCollection")
    @JsonIgnore
    private List<Role> roleCollection;
    @OneToMany(mappedBy = "user")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    private List<Post> posts;
    @OneToMany(mappedBy = "user")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    private List<Adoption> adoptions;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String email, String phone, boolean active) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Role> getRoleCollection() {
        return roleCollection;
    }

    public void setRoleCollection(List<Role> roleCollection) {
        this.roleCollection = roleCollection;
    }

    public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public List<Adoption> getAdoptions() {
		return adoptions;
	}

	public void setAdoptions(List<Adoption> adoptions) {
		this.adoptions = adoptions;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.adoptame.services.entities.User[ id=" + id + " ]";
    }

}
