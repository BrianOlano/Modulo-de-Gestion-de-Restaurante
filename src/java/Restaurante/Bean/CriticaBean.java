
package Restaurante.Bean;

public class CriticaBean 
{
    private int Id;
    private int IdRestaurantes;
    private int IdUsuario;
    private String plato;
    private String fecha;
    private int Ranking;
    private String Descripcion;

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

    /**
     * @return the plato
     */
    public String getPlato() {
        return plato;
    }

    /**
     * @param plato the plato to set
     */
    public void setPlato(String plato) {
        this.plato = plato;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the Ranking
     */
    public int getRanking() {
        return Ranking;
    }

    /**
     * @param Ranking the Ranking to set
     */
    public void setRanking(int Ranking) {
        this.Ranking = Ranking;
    }

    /**
     * @return the Descripcion
     */
    public String getDescripcion() {
        return Descripcion;
    }

    /**
     * @param Descripcion the Descripcion to set
     */
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
    
}
