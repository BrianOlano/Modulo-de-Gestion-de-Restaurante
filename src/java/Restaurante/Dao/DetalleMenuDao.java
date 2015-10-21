
package Restaurante.Dao;
import Restaurante.Bean.DetallemenuBean;
import Restaurante.Conexion.conecctionDBmsql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DetalleMenuDao {
    ArrayList<DetallemenuBean> lista = null;
    Connection              cnn = null;
    PreparedStatement        pt = null;
    ResultSet                rs = null;
    
    public ArrayList<DetallemenuBean> ListaDetalleMenu()
    {
        try
        {
            conecctionDBmsql cn = new conecctionDBmsql();
            
            cnn = cn.getconecctionBDMysql();
            
            pt=cnn.prepareStatement("select IdDetalle_Menu, Plato, Precio from Detalle_Menu");
            rs=pt.executeQuery();
            lista = new ArrayList<DetallemenuBean>();
            while(rs.next())
            {
                DetallemenuBean objDetalleMenu=new DetallemenuBean();
                objDetalleMenu.setId(rs.getInt(1));
                objDetalleMenu.setPlato(rs.getString(2));
                objDetalleMenu.setPrecio(rs.getInt(3));
                lista.add(objDetalleMenu);
            }
            rs.close();
            pt.close();
            cnn.close();
            return lista;
        }
        catch(Exception e)
        {
            return lista;
        }
    }
    public int GrabarDetalleMenu(DetallemenuBean objDetalleMenu)
    {
        int grabar = 0 ;
        
        try
        {
            conecctionDBmsql cn = new conecctionDBmsql();
            cnn= cn.getconecctionBDMysql();
            pt=cnn.prepareStatement("Insert into "
                    + "Detalle_Menu(Plato, Precio) "
                    + "values(?, ?)");
            pt.setString(1, objDetalleMenu.getPlato());
            pt.setInt(2, objDetalleMenu.getPrecio());
            grabar = pt.executeUpdate();
            pt.close();
            cnn.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return grabar;
    }
    public int ActualizarDetalleMenu(DetallemenuBean objDetalleMenu)
    {
        int act = 0;
        try
        {
            conecctionDBmsql cn = new conecctionDBmsql();
            cnn = cn.getconecctionBDMysql();
            pt = cnn.prepareStatement("update DetalleMenu set Plato = ?, Precio = ? "
                    + "where IdDetalle_Menu = ?");
            pt.setString(1, objDetalleMenu.getPlato());
            pt.setInt(2, objDetalleMenu.getPrecio());
            pt.setInt(3, objDetalleMenu.getId());
            act = pt.executeUpdate();
            pt.close();
            cnn.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return act;
    }   
    public int EliminarDetalleMenu(DetallemenuBean objdeDetallemenu)
    {
        int estado = 0;
        try
        {
            conecctionDBmsql cn = new conecctionDBmsql();
            cnn = cn.getconecctionBDMysql();
            pt=cnn.prepareStatement("delete from Detalle_Menu where IdDetalle_Menu=?");
            pt.setInt(1, objdeDetallemenu.getId());
            estado = pt.executeUpdate();
            pt.close();
        }
        catch(Exception e)
        {
            
        }   
        return estado;
    }
}
