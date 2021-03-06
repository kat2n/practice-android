package com.derrick.park.assignment3_contacts.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ContactList {

  @SerializedName("results")
  @Expose
  private ArrayList<Contact> contacts;

  public ArrayList<Contact> getContacts() {
    return contacts;
  }
}
