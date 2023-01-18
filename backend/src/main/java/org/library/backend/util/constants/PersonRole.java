package org.library.backend.util.constants;

public enum PersonRole {
    ROLE_BANNED("ROLE_BANNED"),
    ROLE_USER("ROLE_USER"),
    ROLE_RESTRICTED("ROLE_RESTRICTED"),
    ROLE_SUBSCRIBED("ROLE_SUBSCRIBED"),
    ROLE_PRIVILEGED("ROLE_PRIVILEGED"),
    ROLE_ADMIN("ROLE_ADMIN");

    PersonRole(String roleUser) {
    }
}
