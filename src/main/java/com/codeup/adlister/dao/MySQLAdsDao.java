package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUser(),
                config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<Ad> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public List<Ad> byUser(Long userId) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads WHERE user_id = " + userId);
            System.out.println(stmt);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving ads by user.", e);
        }
    }

    @Override
    public Ad individualAd(Long id) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads WHERE id = " + id);
            System.out.println(stmt);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            Ad ad = extractAd(rs);
            System.out.println(ad);
            return ad;
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving the ad.", e);
        }

    }


    @Override
    public int deleteAd(Long id) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("DELETE * FROM ads WHERE id = " + id);
            System.out.println(stmt);
            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted;

        } catch (SQLException e) {
            throw new RuntimeException("Error deleting the ad.", e);
        }

    }


    @Override
    public Long insert(Ad ad) {
        try {
            String insertQuery = "INSERT INTO ads(user_id, title, description) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }


    @Override
    public Long edit(Ad ad) {
        try {
            String insertQuery = "UPDATE ads SET user_id = ?, title = ?, description = ? WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(insertQuery);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.setLong(4, ad.getId());
            System.out.println(stmt);
            stmt.executeUpdate();
            return ad.getId();
        } catch (SQLException e) {
            throw new RuntimeException("Error editing the ad.", e);
        }
    }


    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
            rs.getLong("id"),
            rs.getLong("user_id"),
            rs.getString("title"),
            rs.getString("description")
        );
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }
}
