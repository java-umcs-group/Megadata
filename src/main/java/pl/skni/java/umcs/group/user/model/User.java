package pl.skni.java.umcs.group.user.model;

import com.google.common.collect.Lists;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Jakub Pyda on 31.03.2016.
 */
@Entity
@Table(name = "M_User")
public class User implements UserDetails {
    @Id
    @Column(name = "userId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Column(name = "userName")
    String userName;

    @Embedded
    UserDetailsVO userDetails;

    @Column(name = "password")
    String password;

    @JoinColumn(name = "authorityId")
    @ManyToOne
    Authority authority;

    Boolean expired;
    Boolean locked;
    Boolean enabled;

    public User(String userName, String password, Authority authority, String firstName, String lastName, String email, String address, String phoneNumber, String zipCode, String city) {
        this.userName = userName;
        this.password = password;
        this.authority = authority;
        this.userDetails = new UserDetailsVO(firstName, lastName, city, email, address, zipCode, phoneNumber);
        this.expired = false;
        this.locked = false;
        this.enabled = true; //todo enabled true po wysłaniu maila i potwierdzeniu konta
    }

    public User() {
    }

    public void updateUserDetails(String firstName, String lastName, String city, String email, String address, String zipCode, String phoneNumber) {
        this.userDetails = new UserDetailsVO(firstName, lastName, city, email, address, zipCode, phoneNumber);
    }

    public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
        List<GrantedAuthority> authorities = Lists.newArrayList();

        roles.stream()
                .forEach(a -> authorities.add(new SimpleGrantedAuthority(a)));

        return authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<String> roles = Lists.newArrayList(authority.getAuthority());
        return getGrantedAuthorities(roles);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return !expired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !expired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
