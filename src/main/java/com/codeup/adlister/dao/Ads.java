package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();

    List<Ad> byUser(Long userId);


    List<Ad> byTitle(String title);

    Ad individualAd(Long id);


    // insert a new ad and return the new ad's id
    Long insert(Ad ad);

}
