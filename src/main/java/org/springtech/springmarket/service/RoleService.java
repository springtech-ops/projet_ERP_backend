package org.springtech.springmarket.service;

import org.springtech.springmarket.domain.Role;

import java.util.Collection;

public interface RoleService {
    Role getRoleByUserId(Long id);

    Collection<Role> getRoles();
}
