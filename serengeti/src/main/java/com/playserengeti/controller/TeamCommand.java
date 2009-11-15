package com.playserengeti.controller;

import java.util.Map;

import com.playserengeti.domain.User;

public class TeamCommand {

    Integer teamId;
    String name;
    String color;
    User leader;
    String description;
    String homeBase;
    Map<Integer, String> members;
    Integer[] invitees;
    Integer[] removals;
    Map<Integer, String> candidates;

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public User getLeader() {
        return leader;
    }

    public void setLeader(User leader) {
        this.leader = leader;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHomeBase() {
        return homeBase;
    }

    public void setHomeBase(String homeBase) {
        this.homeBase = homeBase;
    }

    public Map<Integer, String> getMembers() {
        return members;
    }

    public void setMembers(Map<Integer, String> members) {
        this.members = members;
    }

    public Integer[] getInvitees() {
        return invitees;
    }

    public void setInvitees(Integer[] invitees) {
        this.invitees = invitees;
    }

    public Integer[] getRemovals() {
        return removals;
    }

    public void setRemovals(Integer[] removals) {
        this.removals = removals;
    }

    public Map<Integer, String> getCandidates() {
        return candidates;
    }

    public void setCandidates(Map<Integer, String> candidates) {
        this.candidates = candidates;
    }
}
