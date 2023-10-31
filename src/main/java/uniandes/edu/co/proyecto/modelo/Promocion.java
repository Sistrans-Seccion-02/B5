package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "promociones")
public class Promocion {
    @Id
    private String nombreplan;
    private Float descuentoalojamiento;
    private Float descuentocomida;
    private Float descuentoservicios;
    private Float costo;
    private Integer diasminimaestadia;

    public Promocion(String nombreplan, Float descuentoalojamiento, Float descuentocomida, Float descuentoservicios,
            Float costo, Integer diasminimaestadia) {
        this.nombreplan = nombreplan;
        this.descuentoalojamiento = descuentoalojamiento;
        this.descuentocomida = descuentocomida;
        this.descuentoservicios = descuentoservicios;
        this.costo = costo;
        this.diasminimaestadia = diasminimaestadia;
    }

    public Promocion(){;}

    public String getNombrePlan() {
        return nombreplan;
    }

    public void setNombrePlan(String nombreplan) {
        this.nombreplan = nombreplan;
    }

    public Float getDescuentoAlojamiento() {
        return descuentoalojamiento;
    }

    public void setDescuentoAlojamiento(Float descuentoalojamiento) {
        this.descuentoalojamiento = descuentoalojamiento;
    }

    public Float getDescuentoComida() {
        return descuentocomida;
    }

    public void setDescuentoComida(Float descuentoComida) {
        this.descuentocomida = descuentoComida;
    }

    public Float getDescuentoServicios() {
        return descuentoservicios;
    }

    public void setDescuentoServicios(Float descuentoservicios) {
        this.descuentoservicios = descuentoservicios;
    }

    public Float getCosto() {
        return costo;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }

    public Integer getDiasMinimaEstadia() {
        return diasminimaestadia;
    }

    public void setDiasMinimaEstadia(Integer diasminimaestadia) {
        this.diasminimaestadia = diasminimaestadia;
    }
}