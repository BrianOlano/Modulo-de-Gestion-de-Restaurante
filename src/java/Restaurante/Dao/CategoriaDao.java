
package Restaurante.Dao;
import Restaurante.Bean.CategoriaBean;
import Restaurante.Conexion.conecctionDBmsql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CategoriaDao 
{
    ArrayList<CategoriaBean> lista = null;
    Connection              cnn = null;
    PreparedStatement        pt = null;
    ResultSet                rs = null;
    
    public ArrayList<CategoriaBean> ListaCategoria()
    {
        try
        {
            conecctionDBmsql cn = new conecctionDBmsql();
            
            cnn = cn.getconecctionBDMysql();
            
            pt=cnn.prepareStatement("select IdCategoria, Descripcion from Categoria");
            rs=pt.executeQuery();
            lista = new ArrayList<CategoriaBean>();
            while(rs.next())
            {
                CategoriaBean objCategoria=new CategoriaBean();
                objCategoria.setId(rs.getInt(1));
                objCategoria.setDescripcion(rs.getString(2));
                lista.add(objCategoria);
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
    public int GrabarCategoria(CategoriaBean objCategoria)
    {
        int grabar = 0 ;
        
        try
        {
            conecctionDBmsql cn = new conecctionDBmsql();
            cnn= cn.getconecctionBDMysql();
            pt=cnn.prepareStatement("Insert into "
                    + "Categoria(Descripcion) "
                    + "values(?)");
            pt.setString(1, objCategoria.getDescripcion());
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
    public int ActualizarCategoria(CategoriaBean objCategoria)
    {
        int act = 0;
        try
        {
            conecctionDBmsql cn = new conecctionDBmsql();
            cnn = cn.getconecctionBDMysql();
            pt = cnn.prepareStatement("update Categoria set Descripcion = ? "
                    + "where IdCategoria = ?");
            pt.setString(1, objCategoria.getDescripcion());
            pt.setInt(2, objCategoria.getId());
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
    public int EliminarCategoria(CategoriaBean objCategoria)
    {
        int estado = 0;
        try
        {
            conecctionDBmsql cn = new conecctionDBmsql();
            cnn = cn.getconecctionBDMysql();
            pt=cnn.prepareStatement("delete from Categoria where IdCategoria=?");
            pt.setInt(1, objCategoria.getId());
            estado = pt.executeUpdate();
            pt.close();
        }
        catch(Exception e)
        {
            
        }   
        return estado;
    }
}
