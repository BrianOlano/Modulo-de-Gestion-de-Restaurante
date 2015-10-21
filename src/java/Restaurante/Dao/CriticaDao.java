
package Restaurante.Dao;
import Restaurante.Bean.CriticaBean;
import Restaurante.Conexion.conecctionDBmsql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CriticaDao 
{
    Connection             cnn=null;
    PreparedStatement      pt=null;
    ResultSet              rs=null;
    ArrayList<CriticaBean> lista = null;
    

   public ArrayList<CriticaBean> ListaCritica(){
       
       
       try{
            conecctionDBmsql cn = new conecctionDBmsql();
            //connectionBD cn = new connectionBD();
            cnn = cn.getconecctionBDMysql();

            pt=cnn.prepareStatement("select c.IdCritica, c.IdRestaurante, c.IdUsuario, c.Plato, c.Fecha, c.Rating, "
                    + "a.Descripcion "
                    + "from Critica c "
                    + "inner join Tipo_Actividad ta on ta.CodTipoAct = a.CodTipoAct "
                    + "inner join Periodo p on p.CodPeriodo = a.CodPeriodo ");
            rs=pt.executeQuery();
            lista = new ArrayList<CriticaBean>();
            while(rs.next()){
                CriticaBean objCritica=new CriticaBean();
                objCritica.setId(rs.getInt(1));
                objCritica.setIdRestaurantes(rs.getInt(2));
                objCritica.setIdUsuario(rs.getInt(3));
                objCritica.setPlato(rs.getString(4));
                objCritica.setFecha(rs.getString(5));
                objCritica.setRanking(rs.getInt(6));
                objCritica.setDescripcion(rs.getString(7));
                lista.add(objCritica);                            
            }
            rs.close();
            pt.close();
            cnn.close();
            return lista;
       } 
       catch(Exception e){
           return lista;
       }
   }
      
    public int GrabarCritica(CriticaBean objCritica)
    {
        int grabar = 0 ;
                
        try 
        {     
            conecctionDBmsql cn = new conecctionDBmsql();
            cnn = cn.getconecctionBDMysql();
            pt=cnn.prepareStatement("INSERT INTO "
                    + "Critica(IdRestaurante, IdUsuario, Plato, Fecha, Rating, Descripcion) "
                    + "values(?, ?, ?, ?, ?, ?)");
            pt.setInt(1, objCritica.getIdRestaurantes());
            pt.setInt(2,objCritica.getIdUsuario());
            pt.setString(3,objCritica.getPlato());
            pt.setString(4,objCritica.getFecha());
            pt.setInt(5, objCritica.getRanking());
            pt.setString(6, objCritica.getDescripcion());
            grabar =  pt.executeUpdate();
            pt.close();          
            cnn.close();
        } 
      catch (Exception e)
      {
          System.out.println(e);
      }              
        return grabar;
    } 
    public int ActualizarCritica(CriticaBean objCritica)
    {
        int act=0;
        try
        {
            conecctionDBmsql cn = new conecctionDBmsql();
            cnn = cn.getconecctionBDMysql();
            pt=cnn.prepareStatement("update Critica set IdRestaurante = ?, IdUsuario = ?, Plato = ?, Fecha = ?, "
                                + "Rating = ?, Descripcion = ? where IdCritica = ?"); 
            pt.setInt(1, objCritica.getIdRestaurantes());
            pt.setInt(2,objCritica.getIdUsuario());
            pt.setString(3,objCritica.getPlato());
            pt.setString(4,objCritica.getFecha());
            pt.setInt(5, objCritica.getRanking());
            pt.setString(6, objCritica.getDescripcion());
            pt.setInt(7, objCritica.getId());
            act = pt.executeUpdate();            
            pt.close();
            cnn.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
        return act;
    }
    public int EliminarCritica(CriticaBean objCritica) {
        int estado = 0;
        try{
            conecctionDBmsql cn = new conecctionDBmsql();
            cnn = cn.getconecctionBDMysql();
            pt=cnn.prepareStatement("delete from Critica where IdCritica = ?");
            pt.setInt(1, objCritica.getId());
            estado = pt.executeUpdate();
            pt.close();
        } catch(Exception e){
            
        }
        return estado;
    }
    
}
