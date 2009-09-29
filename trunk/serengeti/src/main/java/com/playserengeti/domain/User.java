package com.playserengeti.domain;

/**
 * A game user, or player.
 */
public class User {

    private Integer id;
    private String loginName;
    private String displayName;
    // TODO: private String avatar;
    // TODO: private Team team;

    public User(Integer id, String loginName, String displayName) {
        this.id = id;
        this.loginName = loginName;
        this.displayName = displayName;
    }

    public Integer getId() {
        return id;
    }

    public String getLoginName() {
        return loginName;
    }

    public String getDisplayName() {
        return displayName;
    }

    // TODO: Getters and setters for team and avatar

    // TODO: equals, hashCode, toString.
}
