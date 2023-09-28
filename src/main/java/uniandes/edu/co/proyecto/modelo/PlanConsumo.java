package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "planesConsumo")
public class PlanConsumo {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer id;
    private String nombrePlan;
    private String descripccion;

    public PlanConsumo(String nombrePlan, String descripccion)
    {
        this.nombrePlan = nombrePlan;
        this.descripccion = descripccion;
    }

    public PlanConsumo()
    {;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombrePlan() {
        return nombrePlan;
    }

    public void setNombrePlan(String nombrePlan) {
        this.nombrePlan = nombrePlan;
    }

    public String getDescripccion() {
        return descripccion;
    }

    public void setDescripccion(String descripccion) {
        this.descripccion = descripccion;
    }

    
    
}
