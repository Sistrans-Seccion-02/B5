package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "gimnasios")
public class Gimnasio {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer idTipoServicio;
    private Integer capacidad;
    private String maquinas;

    public Gimnasio(String maquinas, Integer capacidad)
    {
        this.capacidad = capacidad;
        this.maquinas = maquinas;
    }

    public Gimnasio()
    {;}

    public Integer getIdTipoServicio() {
        return idTipoServicio;
    }

    public void setIdTipoServicio(Integer idTipoServicio) {
        this.idTipoServicio = idTipoServicio;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public String getMaquinas() {
        return maquinas;
    }

    public void setMaquinas(String maquinas) {
        this.maquinas = maquinas;
    }

    



    
}
