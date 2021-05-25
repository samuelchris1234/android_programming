This android project requires XAMPP to be installed before runs correctly.

Steps on how to get it working :

1. Download and install XAMPP (Any version should be fine, I personally use XAMPP version 3.2.4).
2. Start XAMPP first in the XAMPP control panel. The only services that needs to be running is Apache and MySQL.
3. After install, open http://localhost/phpmyadmin.
4. Go to the assets folder on Github and open file named "sql_query.txt".
5. Copy the SQL query "CREATE DATABASE cinema" inside and paste it on the SQL tab on the top bar, then on the bottom right click "Go".
6. Then click the cinema database on the left, copy and paste the SQL query "CREATE TABLE movies ..." and paste it on the SQL tab on the top bar, then on the bottom right click "Go".
7. Copy the images folder inside assets in Github, then make a new folder named "android" inside the installation directory\htdocs folder and paste it there.
(For example, if the installation directory is D:\XAMPP then it should be D:\XAMPP\htdocs\android)
8. Do the exact same thing as step 6 but this time with the movies.php file (No need to create the "android" folder again of course).
