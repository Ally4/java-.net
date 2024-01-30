
package model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author jeremie
 */
@Entity
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Boolean active;
    @ManyToMany(mappedBy = "roles")
    private Set<Users> users = new HashSet<>();
    @ManyToMany(mappedBy = "roles")
    private Set<Rights> rights = new HashSet<>();

    public Roles() {
    }

    public Roles(Integer id) {
        this.id = id;
    }

    public Roles(Integer id, String name, Boolean active) {
        this.id = id;
        this.name = name;
        this.active = active;
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

    public Set<Users> getUsers() {
        return users;
    }

    public void setUsers(Set<Users> users) {
        this.users = users;
    }

    public Set<Rights> getRights() {
        return rights;
    }

    public void setRights(Set<Rights> rights) {
        this.rights = rights;
    }
    
}
