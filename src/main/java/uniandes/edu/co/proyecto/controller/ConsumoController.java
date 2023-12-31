package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.Consumo;
import uniandes.edu.co.proyecto.repositorio.ConsumoRepository;

@Controller
public class ConsumoController {

    @Autowired
    private ConsumoRepository consumoRepository;

    @GetMapping("/consumos")
    public String consumos(Model model){
        model.addAttribute("consumos", consumoRepository.darConsumo());
        return "consumos";
    }

    @GetMapping("/consumos/new")
    public String createConsumoForm(Model model){
        model.addAttribute("consumo", new Consumo());
        return "create_consumo";
    }

    @PostMapping("/consumos/new/save")
    public String consumoGuardar(@ModelAttribute Consumo consumo){
        consumoRepository.crearConsumo(consumo.getCosto(), consumo.iscargadoHabitacion(), consumo.getFecha(), consumo.getGimnasios_idtiposervicio(), consumo.getSalones_idtiposervicio(), consumo.getPrestamos_idtiposervicio(), consumo.getSupermercados_idtiposervicio(), consumo.getPiscinas_idtiposervicio(), consumo.getTiendas_idtiposervicio(), consumo.getInternet_idtiposervicio(), consumo.getBares_idtiposervicio(), consumo.getLavanderias_idtiposervicio(), consumo.getRestaurantes_idtiposervicio(), consumo.getSpas_idtiposervicio(), consumo.getHabitaciones_numeroHabitacion());
        return "redirect:/consumos";
    }
    
    @GetMapping("/consumos/{id}/edit/")
    public String consumoEditarForm(@PathVariable("id") int id, Model model){
        Consumo consumo = consumoRepository.darConsumoPorId(id);
        if (consumo == null) {
            model.addAttribute("consumo", consumo);
            return "barConsumo";}
        else {
            return "redirect:/consumos";
        }
        }

    @PostMapping("/consumos/{id}/edit/save")
    public String consumoEditGuardar(@PathVariable("id") int id, @ModelAttribute Consumo consumo){
        consumoRepository.actualizarConsumo(consumo.getCosto(), consumo.iscargadoHabitacion(), consumo.getFecha(), consumo.getGimnasios_idtiposervicio(), consumo.getSalones_idtiposervicio(), consumo.getPrestamos_idtiposervicio(), consumo.getSupermercados_idtiposervicio(), consumo.getPiscinas_idtiposervicio(), consumo.getTiendas_idtiposervicio(), consumo.getInternet_idtiposervicio(), consumo.getBares_idtiposervicio(), consumo.getLavanderias_idtiposervicio(), consumo.getRestaurantes_idtiposervicio(), consumo.getSpas_idtiposervicio(), consumo.getHabitaciones_numeroHabitacion(), id);
        return "redirect:/consumos";
    }

    @GetMapping("/consumos/{id}/delete")
    public String consumoEliminar(@PathVariable("id") int id){
        consumoRepository.deleteById(id);
        return "redirect:/consumos";
    }
    
}

