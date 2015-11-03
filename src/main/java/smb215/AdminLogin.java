/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smb215;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Peter
 */
@Entity
@Table(name = "admin-login")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdminLogin.findAll", query = "SELECT a FROM AdminLogin a"),
    @NamedQuery(name = "AdminLogin.findById", query = "SELECT a FROM AdminLogin a WHERE a.id = :id"),
    @NamedQuery(name = "AdminLogin.findByUsername", query = "SELECT a FROM AdminLogin a WHERE a.username = :username"),
    @NamedQuery(name = "AdminLogin.findByPassword", query = "SELECT a FROM AdminLogin a WHERE a.password = :password"),
    @NamedQuery(name = "AdminLogin.findByEmail", query = "SELECT a FROM AdminLogin a WHERE a.email = :email"),
    @NamedQuery(name = "AdminLogin.findByAttempts", query = "SELECT a FROM AdminLogin a WHERE a.attempts = :attempts"),
    @NamedQuery(name = "AdminLogin.findByFlag", query = "SELECT a FROM AdminLogin a WHERE a.flag = :flag")})
public class AdminLogin implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Password")
    private String password;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "attempts")
    private int attempts;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Flag")
    private int flag;

    public AdminLogin() {
    }

    public AdminLogin(Integer id) {
        this.id = id;
    }

    public AdminLogin(Integer id, String username, String password, String email, int attempts, int flag) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.attempts = attempts;
        this.flag = flag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
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
        if (!(object instanceof AdminLogin)) {
            return false;
        }
        AdminLogin other = (AdminLogin) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "smb215.AdminLogin[ id=" + id + " ]";
    }
    
}