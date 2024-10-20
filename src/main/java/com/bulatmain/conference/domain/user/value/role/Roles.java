package com.bulatmain.conference.domain.user.value.role;

import dev.mccue.guava.collect.TreeMultiset;

import java.util.*;

public class Roles {
    private TreeMultiset<Role> roles;
    private final Comparator<Role> roleComparator
            = Comparator.comparing(Role::name);

    public Roles() {
        roles = TreeMultiset.create(roleComparator);
    }

    public Roles(TreeMultiset<Role> roles) {
        if (roles.comparator().equals(roleComparator)) {
            this.roles = roles;
        } else {
            this.roles.addAll(roles);
        }
    }

    public Roles(Role... roles) {
        this(Arrays.asList(roles));
    }

    public Roles(Collection<Role> roles) {
        this();
        this.roles.addAll(roles);
    }

    public Collection<Role> getCollection() {
        return roles;
    }

    public boolean has(Class<? extends Role> roleClass) {
        return roles.stream().anyMatch(role ->
                Objects.equals(role.getClass(), roleClass)
        );
    }

    public boolean has(String roleName) {
        return roles.stream().anyMatch(role ->
                Objects.equals(role.name(), roleName)
        );
    }

    public void add(Role role) {
        roles.add(role);
    }
}
