package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "promociones")
public class Promocion {

    @Id
    private String nombrePlan;
    private Float descuentoAlojamiento;
    private Float descuentoComidas;
    private Float descuentoServicios;
    private Float costo;
    private Integer diasMinimaEstadia;

    public Promocion(Float descuentoAlojamiento, Float descuentoComidas, Float descuentoServicios, Float costo,Integer diasMinimaEstadia)
    {
        this.descuentoAlojamiento = descuentoAlojamiento;
        this.descuentoComidas = descuentoComidas;
        this.descuentoServicios = descuentoServicios;
        this.costo = costo;
        this.diasMinimaEstadia = diasMinimaEstadia;
    }

    public Promocion()
    {;}


    public String getNombrePlan() {
        return nombrePlan;
    }

    public void setNombrePlan(String nombrePlan) {
        this.nombrePlan = nombrePlan;
    }

    public Float getDescuentoAlojamiento() {
        return descuentoAlojamiento;
    }

    public void setDescuentoAlojamiento(Float descuentoAlojamiento) {
        this.descuentoAlojamiento = descuentoAlojamiento;
    }

    public Float getDescuentoComidas() {
        return descuentoComidas;
    }

    public void setDescuentoComidas(Float descuentoComidas) {
        this.descuentoComidas = descuentoComidas;
    }

    public Float getDescuentoServicios() {
        return descuentoServicios;
    }

    public void setDescuentoServicios(Float descuentoServicios) {
        this.descuentoServicios = descuentoServicios;
    }

    public Float getCosto() {
        return costo;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }

    public Integer getDiasMinimaEstadia() {
        return diasMinimaEstadia;
    }

    public void setDiasMinimaEstadia(Integer diasMinimaEstadia) {
        this.diasMinimaEstadia = diasMinimaEstadia;
    }

    


}