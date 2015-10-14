
package Restaurante.Bean;

public class DetallemenuBean 
{
    private int Id;
    private String plato;
    private int precio;

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
     * @return the precio
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    
}
