This plugin is mainly for servers that largely depend on MySQL, like servers that use LogBlock or xAuth. It basically checks for a connection to a MySQL database every user specified interval. If it doesn't connect, it sends an error message on the console. After user given attempts to try connecting to the database, it shuts the server down. A connections.log file located in the plugin's data folder will save the time at which the last successful connection was made to the database before failure, and the time the server was shutdown.

Please report any issues with this plugin [HERE](https://github.com/vik1395/MySQLChecker-Minecraft/issues)

If you like my work, please consider donating, I would greatly appreciate it. [![Image](https://www.paypalobjects.com/en_US/i/btn/btn_donate_LG.gif)](https://www.paypal.com/cgi-bin/webscr?cmd=_donations&business=vik1395lp%40gmail%2ecom&lc=US&item_name=Spigot%20Plugins&item_number=LegitPlay%2enet%20Plugin%20Dev&no_note=0&currency_code=USD&bn=PP%2dDonationsBF%3abtn_donateCC_LG%2egif%3aNonHostedGuest)

**Permissions**
-------------
    mysqlchecker.notify - Notifies players with this permission about a connection failure.

**Config.yml**
-------------
    # Please enter the Host of your MySQL Database here.
    
    Host: 127.0.0.1
    
    # Please enter the port where your MySQL is hosted.
    
    Port: '3306'
    
    # The Username which should be used to auth against the Database
    
    Username: root
    
    # The Password which should be used to auth against the Database
    
    Password: ''
    
    # The name of the database where BungeeAuth's Tables shall be created.
    
    Database: Bungee
    
    # Interval is the time in minutes before the plugin checks for a connection to the SQL Database again.
    
    Interval: 5
    
    # Number of attempts before the server is shut down.
    
    Max Attempts: 3

**Connection.log**
-------------
a sample connection.log file will look like this:

    Last successful connection: Tue 2014.10.14 at 10:47:53 PM EDT
    
    Server Shutdown: Tue 2014.10.14 at 10:50:54 PM EDT

This plugin is licensed under [CC Attribution-NonCommercial-ShareAlike 4.0 International](http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en_US). 

In very basic terms, Do whatever you want with the code of this plugin, as long as you give credits to the author and/or the plugin itself.
