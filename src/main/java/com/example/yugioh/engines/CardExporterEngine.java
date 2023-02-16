package com.example.yugioh.engines;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

public class CardExporterEngine {

    /**
     * This function will export API data to database
     * @throws SQLException
     * @throws UnsupportedEncodingException
     */
    public static void exportApiData() throws SQLException, UnsupportedEncodingException {
        JsonNode cards = ApiEngine.getCardData().get("data");
        DataBaseEngine.insertCard(cards);
    }

    public static void main(String args[]) throws SQLException, UnsupportedEncodingException {
        exportApiData();
    }
}