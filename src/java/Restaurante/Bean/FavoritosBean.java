
package Restaurante.Bean;

public class FavoritosBean 
{
    private int Id;
    private String Fecha;
    private int IdRestaurantes;
    private int IdUsuario;

    /**
     * @return the Id
     */
    public int getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(int Id) {
        this.Id = Id;
    }

    /**
     * @return the Fecha
     */
    public String getFecha() {
        return Fecha;
    }

    /**
     * @param Fecha the Fecha to set
     */
    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    /**
     * @return the IdRestaurantes
     */
    public int getIdRestaurantes() {
        return IdRestaurantes;
    }

    /**
     * @param IdRestaurantes the IdRestaurantes to set
     */
    public void setIdRestaurantes(int IdRestaurantes) {
        this.IdRestaurantes = IdRestaurantes;
    }

    /**
     * @return the IdUsuario
     */
    public int getIdUsuario() {
        return IdUsuario;
    }

    /**
     * @param IdUsuario the IdUsuario to set
     */
    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }
    
    
}
