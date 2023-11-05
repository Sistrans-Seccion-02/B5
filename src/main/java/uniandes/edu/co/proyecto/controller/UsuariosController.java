package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Usuario;
import uniandes.edu.co.proyecto.repositorio.HabitacionRepository;
import uniandes.edu.co.proyecto.repositorio.TipoUsuarioRepository;
import uniandes.edu.co.proyecto.repositorio.UsuarioRepository;

@Controller
public class UsuariosController {

    @Autowired
    private UsuarioRepository usuariosRepository;

    @Autowired
    private TipoUsuarioRepository tiposUsuarioRepository;

    @Autowired
    private HabitacionRepository habitacionRepository;

    @GetMapping("/usuarios")
    public String usuarios(Model model) {
        model.addAttribute("usuarios", usuariosRepository.darUsuarios());
        return "usuarios";
    }

    @GetMapping("/usuarios/new")
        public String usuarioForm(Model model) {
        model.addAttribute("usuarios", new Usuario());
        model.addAttribute("tiposUsuario", tiposUsuarioRepository.darTiposUsuario());
        model.addAttribute("habitaciones", habitacionRepository.darHabitaciones());
        return "usuariosNuevo";
    }


    @PostMapping("/usuarios/new/save")
    public String usuariosGuardar(@ModelAttribute Usuario usuario) {
        usuariosRepository.insertarUsuario(usuario.getPk().getId(), usuario.getPk().getTipoId(), usuario.getNombre(), usuario.getTipoUsuario().getTipoUsuario(), usuario.getCorreo(), usuario.getHabitaciones_numeroHabitacion().getNumeroHabitacion());
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/{tipoid}/{id}/edit")
    public String usuariosEditarForm(@PathVariable("tipoid") String tipoid, @PathVariable("id") Integer id, Model model) {
        Usuario usuario = usuariosRepository.darUsuario(id, tipoid);
        if (usuario != null) {
            model.addAttribute("usuario", usuario);
            return "usuarioEditar";
        } else {
            return "redirect:/usuarios";
        }
    }

    @PostMapping("/usuarios/{tipoid}/{id}/edit/save")
    public String usuariosEditarGuardar(@PathVariable("tipoid") String tipoid, @PathVariable("id") Integer id, @ModelAttribute Usuario usuario){
        usuariosRepository.actualizarUsuario(id, usuario.getPk().getTipoId(), usuario.getNombre(), usuario.getTipoUsuario().getTipoUsuario(), usuario.getCorreo(), usuario.getHabitaciones_numeroHabitacion().getNumeroHabitacion());
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/{tipoid}/{id}/delete")
    public String usuariosEliminar(@PathVariable("tipoid") String tipoid, @PathVariable("id") Integer id) {
        usuariosRepository.eliminarUsuario(id, tipoid);
        return "redirect:/usuarios";
    }
}