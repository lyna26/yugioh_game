package com.example.yugioh.engines;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fasterxml.jackson.databind.JsonNode;

public class DataBaseEngine {

    /**
     * This function is a simple select query with the name of the monster
     * @param name card name to search
     * @return the result of the query
     */
    public static ResultSet selectCards(String name) throws SQLException
    {
        Connection connexion = connect();
        String query= "SELECT * FROM card WHERE name LIKE ?";
        PreparedStatement pstm = connexion.prepareStatement(query);
        pstm.setString(1, '%' + name + '%');
        ResultSet resultSet = pstm.executeQuery();
        return resultSet;
    }

    public static ResultSet selectCardById(String id) throws SQLException
    {
        Connection connexion = connect();
        String query= "SELECT * FROM card WHERE id = ?";
        PreparedStatement pstm = connexion.prepareStatement(query);
        pstm.setString(1, id);
        ResultSet resultSet = pstm.executeQuery();
        return resultSet;
    }

    /**
     * This function will connect to the database
     * @return return the connexion
     */
    private static Connection connect()
    {
        //TODO secure all this : confidential infos...
        String url =
                "jdbc:sqlserver://MSI;"
                        + "database=yugioh;"
                        + "integratedSecurity=false;"
                        + "user=Lola;"
                        + "password=Test123;"
                        + "encrypt=false;"
                        + "sendStringParametersAsUnicode=true;"
                        + "useBulkCopyForBatchInsert=true;"
                        + "CharacterSet=UTF-8";
        try
        {
            Connection connexion = DriverManager.getConnection(url);
            return connexion;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * This function will do an insert query
     * @param cards data formatted as Json
     * @exception SQLException
     * @throws UnsupportedEncodingException
     */
    public static void insertCard(JsonNode cards ) throws SQLException, UnsupportedEncodingException
    {
        Connection connexion = connect();
        String reqParam = "insert into card VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstm = connexion.prepareStatement(reqParam);
        int numberOfCard = cards.size();

        for (int i = 0; i < numberOfCard; i++)
        {
            JsonNode card = cards.get(i);
            JsonNode cardImages = card.path("card_images");

            for (JsonNode node : cardImages) {
                System.out.print("node is" + node.path("id").asText());
                pstm.setInt(1, node.path("id").asInt());
                pstm.setString(2, card.path("name").asText());
                pstm.setString(3, card.path("type").asText());
                pstm.setNString(4, card.path("desc").asText());
                pstm.setInt(5, card.path("atk").asInt());
                pstm.setInt(6, card.path("def").asInt());
                pstm.setInt(7, card.path("level").asInt());
                pstm.setString(8, card.path("race").asText());
                pstm.setString(9, card.path("attribute").asText());
                pstm.setString(10, node.path("image_url").asText());
                pstm.setInt(11, card.path("linkval").asInt());
                pstm.setString(12, card.path("linkmarkers").asText());
                pstm.setInt(13, card.path("scale").asInt());
                pstm.setString(14, node.path("image_url_small").asText());
                pstm.addBatch();
            }
        }
        pstm.executeBatch();
    }
}