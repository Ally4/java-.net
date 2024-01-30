
package model;

import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author jeremie
 */
@Entity
public class Rights {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Boolean active;
    @ManyToMany
    @JoinTable(
            name = "roles_rights",
            joinColumns = @JoinColumn(name = "right_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Roles> roles;

    public Rights() {
    }

    public Rights(Integer id) {
        this.id = id;
    }

    public Rights(Integer id, String name, Boolean active, Set<Roles> roles) {
        this.id = id;
        this.name = name;
        this.active = active;
        this.roles = roles;
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }
    
}
