package com.adino.mta.member;

import android.net.Uri;
import android.support.annotation.NonNull;

import com.adino.mta.enums.Ministry;

/**
 * Created by afadinsro on 12/17/17.
 */
//TODO Add comments

public class Member implements Comparable<Member>{

    private String name;
    private String email;
    private String calling_number;
    private String whatsapp_number;
    private String location;
    private Ministry ministry;
    private String img_url;

    public Member(String name, String email, String calling_number, String whatsapp_number,
                  String location, String img_url, Ministry ministry) {
        setName(name);
        setEmail(email);
        setCallingNumber(calling_number);
        setWhatsappNumber(whatsapp_number);
        setLocation(location);
        setImgUrl(img_url);
        setMinistry(ministry);
    }

    public Member(String name, Ministry ministry){
        this.name = name;
        this.ministry = ministry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCallingNumber() {
        return calling_number;
    }

    public void setCallingNumber(String calling_number) {
        this.calling_number = calling_number;
    }

    public String getWhatsappNumber() {
        return whatsapp_number;
    }

    public void setWhatsappNumber(String whatsapp_number) {
        this.whatsapp_number = whatsapp_number;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Ministry getMinistry() {
        return ministry;
    }

    public void setMinistry(Ministry ministry) {
        this.ministry = ministry;
    }

    public String getImgUrl() {
        return img_url;
    }

    public void setImgUrl(String img_url) {
        this.img_url = img_url;
    }

    @Override
    public int compareTo(@NonNull Member other) {
        return this.getName().compareTo(other.getName());
    }
}
