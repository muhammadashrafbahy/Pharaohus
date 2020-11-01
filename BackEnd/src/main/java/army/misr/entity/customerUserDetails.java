package army.misr.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import java.util.Collection;
import java.util.stream.Collectors;

public class customerUserDetails extends employee implements UserDetails {



private employee employee;
//    @ElementCollection(fetch = FetchType.EAGER)
//    @CollectionTable(joinColumns = @JoinColumn(name="user_id"))
//    private List<Authority> authorities;
    public customerUserDetails(final employee employee) {
//        super(employee);
        this.employee=employee;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {


        return null;
    }

    @Override
    public String getPassword() {
        return this.employee.getPassword();
    }

    @Override
    public String getUsername() {
        return this.employee.getEmpName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
