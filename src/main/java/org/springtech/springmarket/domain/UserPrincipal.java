package org.springtech.springmarket.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springtech.springmarket.dto.UserDTO;

import java.util.Collection;

import static org.springtech.springmarket.dtomapper.UserDTOMapper.fromUser;

@RequiredArgsConstructor
public class UserPrincipal implements UserDetails {
    private final User user;
    private final Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //return stream(role.getPermission().split(",".trim())).map(SimpleGrantedAuthority::new).collect(toList());
        return AuthorityUtils.commaSeparatedStringToAuthorityList(role.getPermission());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return user.isNotLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.isEnabled();
    }

    public UserDTO getUser() {
        return fromUser(user, role);
    }
}
