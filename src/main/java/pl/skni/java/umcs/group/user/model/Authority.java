package pl.skni.java.umcs.group.user.model;

import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * Created by Jakub Pyda on 01.04.2016.
 */
@NoArgsConstructor
@Entity
@Table(name = "M_Authority")
public class Authority implements GrantedAuthority {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer authorityId;

    @Column(name = "Role")
    Role role;

    @Override
    public String getAuthority() {
        return String.valueOf(role);
    }

    public Authority(Role role) {
        this.role = role;
    }
}
