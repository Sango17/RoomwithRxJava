package com.alexandreseneviratne.room_with_rxjava.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.alexandreseneviratne.room_with_rxjava.database.entity.Contact;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by Alexandre SENEVIRATNE on 30/10/2018.
 */

@Dao
public interface ContactDAO {

    @Insert
    public long addContact(Contact contact);

    @Update
    public void updateContact(Contact contact);

    @Delete
    public void deleteContact(Contact contact);

    @Query("select * from contacts")
    Flowable<List<Contact>> getContacts();

    @Query("select * from contacts where contact_id == :contactId")
    public Contact getContact(long contactId);
}
