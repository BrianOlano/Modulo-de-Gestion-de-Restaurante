
package Restaurante.Conexion;

import java.sql.*;
public class conecctionDBmsql 
{
    public static Connection getconecctionBDMysql()
        {
            Connection cn = null;
            try 
            {
                Class.forName("com.mysql.jdbc.Driver");
                cn = DriverManager.getConnection("jdbc:mysql://localhost/RESTAURANTE","root","");
                System.out.println("se conecto!");
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
            return cn;
        }
        public static void main(String[] args)
        {
            getconecctionBDMysql();
        }
}
