package me.vik1395.SQLCheck;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import me.vik1395.SQLCheck.Utils.MySQL;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

/*

Author: Vik1395
Project: MySQLChecker

Copyright 2014

Licensed under Creative CommonsAttribution-ShareAlike 4.0 International Public License (the "License");
You may not use this file except in compliance with the License.

You may obtain a copy of the License at http://creativecommons.org/licenses/by-sa/4.0/legalcode

You may find an abridged version of the License at http://creativecommons.org/licenses/by-sa/4.0/
 */

public class main extends JavaPlugin
{
	private int attempt = 0;
	private String lastconn = "";
	public void onEnable()
	{
		getLogger().info("MySQLChecker has successfully started!");
		getLogger().info("Created by Vik1395");
		saveDefaultConfig();
		final String host = getConfig().getString("Host");
		final String port = getConfig().getString("Port");
		final String username = getConfig().getString("Username");
		final String pass = getConfig().getString("Password");
		final String dbName = getConfig().getString("Database");
		int interval = Integer.parseInt(getConfig().getString("Interval"));
		final int maxattempt = Integer.parseInt(getConfig().getString("Max Attempts"));
		
		long intervall = (interval*1200);
		
		BukkitScheduler check = Bukkit.getScheduler();
		check.scheduleSyncRepeatingTask(this, new Runnable()
		{

			@SuppressWarnings("deprecation")
			@Override
			public void run() 
			{
				try
				{
					
					MySQL MySQL = new MySQL(host, port, dbName, username, pass);
					MySQL.openConnection();
					Thread.sleep(15);
					MySQL.closeConnection();
					attempt = 0;
					Date dNow = new Date( );
				    SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");

					lastconn = "Last successful connection: " + ft.format(dNow);
				}
				
				catch(Exception e)
				{
					Bukkit.getConsoleSender().sendMessage("§4[ERROR] Unable to connect to MySQL Database");
					attempt = attempt+1;
					logToFile(lastconn);
					
					for(Player p : getServer().getOnlinePlayers())
					{
						if(p.hasPermission("mysqlchecker.notify"))
						{
							p.sendMessage("&6[MySQLChecker]: §4[ERROR] Unable to connect to MySQL Database");
						}
					}
				}
				
				if(attempt>=maxattempt)
				{
					Date dNow = new Date( );
				    SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
					logToFile("Server Shutdown: " + ft.format(dNow));
					Bukkit.shutdown();
				}
			}
			
		}
		, 0, intervall);
		
		
	}
	
	public void logToFile(String message)
	 
    {
 
        try
        {
            File dataFolder = getDataFolder();
            if(!dataFolder.exists())
            {
                dataFolder.mkdir();
            }
 
            File saveTo = new File(getDataFolder(), "connections.log");
            if (!saveTo.exists())
            {
                saveTo.createNewFile();
            }
 
 
            FileWriter fw = new FileWriter(saveTo, true);
 
            PrintWriter pw = new PrintWriter(fw);
 
            pw.println(message);
 
            pw.flush();
 
            pw.close();
 
        } catch (IOException e)
        {
 
            e.printStackTrace();
 
        }
 
    }
}
