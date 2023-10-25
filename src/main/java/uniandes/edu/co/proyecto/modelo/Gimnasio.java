package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "gimnasios")
public class Gimnasio {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer idTipoServicio;
    private Integer aforo;
    private Integer numMaquinas;
    private String horario;
    private Boolean aplicaCompartido;
    @ManyToOne(optional=true)
    @JoinColumn(name="Hoteles_nombre", referencedColumnName="nombre")
    private String nombreHotel;


    public Gimnasio(Integer numMaquinas, Integer aforo, String horario, Boolean aplicaCompartido, String nombreHotel)
    {
        this.aforo = aforo;
        this.numMaquinas = numMaquinas;
        this.horario = horario;
        this.aplicaCompartido = aplicaCompartido;
        this.nombreHotel = nombreHotel;
    }

    public Gimnasio()
    {;}

    public Integer getIdTipoServicio() {
        return idTipoServicio;
    }

    public void setIdTipoServicio(Integer idTipoServicio) {
        this.idTipoServicio = idTipoServicio;
    }

    public Integer getAforo() {
        return aforo;
    }

    public void setAforo(Integer aforo) {
        this.aforo = aforo;
    }

    public Integer getNumMaquinas() {
        return numMaquinas;
    }

    public void setNumMaquinas(Integer numMaquinas) {
        this.numMaquinas = numMaquinas;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Boolean getAplicaCompartido() {
        return aplicaCompartido;
    }

    public void setAplicaCompartido(Boolean aplicaCompartido) {
        this.aplicaCompartido = aplicaCompartido;
    }

    public String getNombreHotel() {
        return nombreHotel;
    }

    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    
    
    



    
}
