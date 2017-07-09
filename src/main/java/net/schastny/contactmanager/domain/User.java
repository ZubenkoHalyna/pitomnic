package net.schastny.contactmanager.domain;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "USERNAME")
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "ENABLED", columnDefinition = "tinyint(1) DEFAULT 1")
    private boolean enabled;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "userrole",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )

    private List<Role> roles;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
