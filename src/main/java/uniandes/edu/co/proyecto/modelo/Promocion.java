package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "promociones")
public class Promocion {
    @Id
    private String nombrePlan;
    private Float descuentoAlojamiento;
    private Float descuentoComida;
    private Float descuentoServicios;
    private Float costo;
    private Integer diasMinimaEstadia;

    public Promocion(String nombrePlan, Float descuentoAlojamiento, Float descuentoComida, Float descuentoServicios,
            Float costo, Integer diasMinimaEstadia) {
        this.nombrePlan = nombrePlan;
        this.descuentoAlojamiento = descuentoAlojamiento;
        this.descuentoComida = descuentoComida;
        this.descuentoServicios = descuentoServicios;
        this.costo = costo;
        this.diasMinimaEstadia = diasMinimaEstadia;
    }

    public Promocion(){;}

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

    public Float getDescuentoComida() {
        return descuentoComida;
    }

    public void setDescuentoComida(Float descuentoComida) {
        this.descuentoComida = descuentoComida;
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