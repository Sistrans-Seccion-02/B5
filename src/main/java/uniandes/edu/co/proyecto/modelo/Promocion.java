package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "promociones")
public class Promocion {

    private String nombre;
    private Boolean vigencia;
    private Integer descuento;
    private String beneficios;

    public Promocion(String nombre, Boolean vigencia, Integer descuento, String beneficios)
    {
        this.nombre = nombre;
        this.vigencia = vigencia;
        this.descuento = descuento;
        this.beneficios = beneficios;
    }

    public String getNombre() {
        return nombre;
    }

    public Boolean getVigencia() {
        return vigencia;
    }

    public Integer getDescuento() {
        return descuento;
    }

    public String getBeneficios() {
        return beneficios;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setVigencia(Boolean vigencia) {
        this.vigencia = vigencia;
    }

    public void setDescuento(Integer descuento) {
        this.descuento = descuento;
    }

    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }

}