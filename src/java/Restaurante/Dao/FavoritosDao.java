
package Restaurante.Dao;
import Restaurante.Bean.FavoritosBean;
import Restaurante.Conexion.conecctionDBmsql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FavoritosDao 
{
    Connection             cnn=null;
    PreparedStatement      pt=null;
    ResultSet              rs=null;
    ArrayList<FavoritosBean> lista = null;
    

   public ArrayList<FavoritosBean> ListaFavoritos(){
       
       
       try{
            conecctionDBmsql cn = new conecctionDBmsql();
            //connectionBD cn = new connectionBD();
            cnn = cn.getconecctionBDMysql();

            pt=cnn.prepareStatement("select f.IdFavorito, f.Fecha, f.IdRestaurante, f.IdUsuario "
                    + "from Favorito f "
                    + "inner join Favorito ta on ta.IdFavorito = a.IdFavorito "
                    + "inner join Usuario p on p.IdUsuario= a.IdUsuario ");
            rs=pt.executeQuery();
            lista = new ArrayList<FavoritosBean>();
            while(rs.next()){
                FavoritosBean objFavorito=new FavoritosBean();
                objFavorito.setId(rs.getInt(1));
                objFavorito.setFecha(rs.getString(2));
                objFavorito.setIdRestaurantes(rs.getInt(3));
                objFavorito.setIdUsuario(rs.getInt(4));
                lista.add(objFavorito);                            
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
      
    public int GrabarFavorito(FavoritosBean objFavoritos)
    {
        int grabar = 0 ;
                
        try 
        {     
            conecctionDBmsql cn = new conecctionDBmsql();
            cnn = cn.getconecctionBDMysql();
            pt=cnn.prepareStatement("INSERT INTO "
                    + "Actividad(Fecha, IdRestaurante, IdUsuario) "
                    + "values(?, ?, ?)");
            pt.setString(1, objFavoritos.getFecha());
            pt.setInt(2,objFavoritos.getIdRestaurantes());
            pt.setInt(3,objFavoritos.getIdUsuario());
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
    public int ActualizarFavoritos(FavoritosBean objfavoritos)
    {
        int act=0;
        try
        {
            conecctionDBmsql cn = new conecctionDBmsql();
            cnn = cn.getconecctionBDMysql();
            pt=cnn.prepareStatement("update Actividad set Fecha = ?, IdRestaurante = ?, IdUsuario = ? "
                                + " where IdFavorito = ?"); 
            pt.setString(1, objfavoritos.getFecha());
            pt.setInt(2,objfavoritos.getIdRestaurantes());
            pt.setInt(3,objfavoritos.getIdUsuario());
            pt.setInt(4, objfavoritos.getId());
            act = pt.executeUpdate();            
            pt.close();
            cnn.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
        return act;
    }
    public int EliminarFavoritos(FavoritosBean objFavoritos) {
        int estado = 0;
        try{
            conecctionDBmsql cn = new conecctionDBmsql();
            cnn = cn.getconecctionBDMysql();
            pt=cnn.prepareStatement("delete from Favorito where IdFavorito = ?");
            pt.setInt(1, objFavoritos.getId());
            estado = pt.executeUpdate();
            pt.close();
        } catch(Exception e){
            
        }
        return estado;
    }
    
}
