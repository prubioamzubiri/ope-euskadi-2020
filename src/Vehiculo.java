public class Vehiculo {

    private String tipo;
    private String marca;
    private float precio;

    public Vehiculo(String tipo, String marca, float precio)
    {
        this.tipo = tipo;
        this.precio = precio;
        this.marca = marca;
    }

    public String getMarca()
    {
        return marca;
    }

    public String getTipo()
    {
        return tipo;
    }

    public float getPrecio()
    {
        return precio;
    }

    @Override
    public String toString()
    {
        return "Tipo: " + this.tipo + " Marca: " + this.marca + " Precio: " + this.precio;
    }

    
}
