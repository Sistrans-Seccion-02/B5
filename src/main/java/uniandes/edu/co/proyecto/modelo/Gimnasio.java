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
    private Integer idtiposervicio;
    private Integer aforo;
    private Integer nummaquinas;
    private String horario;
    private Boolean aplicacompartido;
    @ManyToOne(optional=true)
    @JoinColumn(name="hoteles_nombre", referencedColumnName="nombre")
    private Hotel nombrehotel;


    public Gimnasio(Integer numMaquinas, Integer aforo, String horario, Boolean aplicaCompartido, Hotel nombreHotel)
    {
        this.aforo = aforo;
        this.nummaquinas = numMaquinas;
        this.horario = horario;
        this.aplicacompartido = aplicaCompartido;
        this.nombrehotel = nombreHotel;
    }

    public Gimnasio()
    {;}

    public Integer getIdtiposervicio() {
        return idtiposervicio;
    }

    public void setIdtiposervicio(Integer idtiposervicio) {
        this.idtiposervicio = idtiposervicio;
    }

    public Integer getAforo() {
        return aforo;
    }

    public void setAforo(Integer aforo) {
        this.aforo = aforo;
    }


    public Integer getNummaquinas() {
        return nummaquinas;
    }

    public void setNummaquinas(Integer nummaquinas) {
        this.nummaquinas = nummaquinas;
    }

    public Boolean getAplicacompartido() {
        return aplicacompartido;
    }

    public void setAplicacompartido(Boolean aplicacompartido) {
        this.aplicacompartido = aplicacompartido;
    }



    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Boolean getAplicaCompartido() {
        return aplicacompartido;
    }

    public void setAplicaCompartido(Boolean aplicaCompartido) {
        this.aplicacompartido = aplicaCompartido;
    }

    public Hotel getNombreHotel() {
        return nombrehotel;
    }

    public void setNombreHotel(Hotel nombreHotel) {
        this.nombrehotel = nombreHotel;
    }

    public Hotel getHotel() {
        return nombrehotel;
    }

    public void setHotel(Hotel nombrehotel) {
        this.nombrehotel = nombrehotel;
    }

    
    
    



    
}
