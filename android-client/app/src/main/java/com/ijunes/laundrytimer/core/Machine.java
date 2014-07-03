package com.ijunes.laundrytimer.core;

import android.text.TextUtils;

import java.io.Serializable;
//TODO FINISH!
public class Machine implements Serializable {

    private static final long serialVersionUID = -7495897652017488896L;

    protected String machineId;
    protected String locationId;
    protected String status;
    protected String type;
    protected String[] machineOptions;
    protected String machineToken;
    protected String gravatarId;
    protected String avatarUrl;


    public String getMachineId() {
        return machineId;
    }

    public void setMachineId(final String machineId) {
        this.machineId = machineId;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(final String phone) {
        this.locationId = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String objectId) {
        this.status = objectId;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getGravatarId() {
        return gravatarId;
    }

    public String getAvatarUrl() {
        if (TextUtils.isEmpty(avatarUrl)) {
            String gravatarId = getGravatarId();
            if (TextUtils.isEmpty(gravatarId))
                gravatarId = GravatarUtils.getHash(getUsername());
            avatarUrl = getAvatarUrl(gravatarId);
        }
        return avatarUrl;
    }

    private String getAvatarUrl(String id) {
        if (!TextUtils.isEmpty(id))
            return "https://secure.gravatar.com/avatar/" + id + "?d=404";
        else
            return null;
    }
}
