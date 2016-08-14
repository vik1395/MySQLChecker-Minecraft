package me.vik1395.SQLCheck.Utils;

import java.sql.Connection;

/**
 * Abstract Database class, serves as a base for any connection method (MySQL, SQLite, etc.)
 * 
 * @author -_Husky_-
 * @author tips48
 * @author Vik1395
 */
public abstract class Database {

    /**
     * Plugin instance, use for plugin.getDataFolder() and plugin.getLogger()
     */

    /**
     * Creates a new Database
     * 
     * @param plugin
     *            Plugin instance
     */
    protected Database() {
    }

    /**
     * Opens a connection with the database
     * 
     * @return Connection opened
     * @throws Exception 
     */
    public abstract Connection openConnection() throws Exception;

    /**
     * Checks if a connection is open with the database
     * 
     * @return true if a connection is open
     */
    public abstract boolean checkConnection();

    /**
     * Gets the connection with the database
     * 
     * @return Connection with the database, null if none
     */
    public abstract Connection getConnection();

    /**
     * Closes the connection with the database
     */
    public abstract void closeConnection();
}