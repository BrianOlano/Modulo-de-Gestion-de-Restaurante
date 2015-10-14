
package Restaurante.Bean;

public class MenuBean 
{
    private int Id;
    private String Fecha;
    private int IdDetalle_Menu;

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
     * @return the IdDetalle_Menu
     */
    public int getIdDetalle_Menu() {
        return IdDetalle_Menu;
    }

    /**
     * @param IdDetalle_Menu the IdDetalle_Menu to set
     */
    public void setIdDetalle_Menu(int IdDetalle_Menu) {
        this.IdDetalle_Menu = IdDetalle_Menu;
    }
    
    
}
