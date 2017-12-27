package com.adino.mta;

import android.net.Uri;
import android.support.annotation.NonNull;

import com.adino.mta.enums.Ministry;

import java.util.ArrayList;
import java.util.Collections;

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
    //TODO add this to constructor when photos are uploaded to Firebase storage.
    private Uri photoURL;

    public Member(String name, String email, String calling_number, String whatsapp_number, String location) {
        //TODO use setter methods instead
        this.name = name;
        this.email = email;
        this.calling_number = calling_number;
        this.whatsapp_number = whatsapp_number;
        this.location = location;
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

    public String getCalling_number() {
        return calling_number;
    }

    public void setCalling_number(String calling_number) {
        this.calling_number = calling_number;
    }

    public String getWhatsapp_number() {
        return whatsapp_number;
    }

    public void setWhatsapp_number(String whatsapp_number) {
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

    public Uri getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(Uri photoURL) {
        this.photoURL = photoURL;
    }

    @Override
    public int compareTo(@NonNull Member other) {
        return this.getName().compareTo(other.getName());
    }
}
