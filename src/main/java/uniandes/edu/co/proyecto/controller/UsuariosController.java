package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Usuario;
import uniandes.edu.co.proyecto.repositorio.UsuarioRepository;

@Controller
public class UsuariosController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/usarios")
    public String usuarios(Model model, Integer id) {
        if(id != null)
        {
            model.addAttribute("usuarios", usuarioRepository.darUsuario(id));
        }
        else{
            model.addAttribute("usuarios", usuarioRepository.darUsuarios());
        }


        return "usuarios";
    }

    @GetMapping("/usuarios/new")
    public String usuarioForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarioNuevo";
    }

    @PostMapping("/usuarios/new/save")
    public String barGuardar(@ModelAttribute Usuario usuario) {
        usuarioRepository.insertarUsuario(usuario.getId(), usuario.getTipoId(), usuario.getNombre(), usuario.getTipoUsuario(), usuario.getCorreo(), usuario.getHabitaciones_numeroHabitacion().getNumeroHabitacion());
        return "redirect:/bares";
    }

    @GetMapping("/usuario/{id}/edit")
    public String usuarioEditarForm(@PathVariable("id") int id, Model model) {
        Usuario usuario = usuarioRepository.darUsuario(id);
        if (usuario != null) {
            model.addAttribute("usuario", usuario);
            return "usuarioEditar";
        } else {
            return "redirect:/usuarios";
        }
    }

    @PostMapping("/usuarios/{id}/edit/save")
    public String usuarioEditarGuardar(@PathVariable("id") int id, @ModelAttribute Usuario usuario) {
        usuarioRepository.actualizarUsuario(id, usuario.getTipoId(), usuario.getNombre(), usuario.getTipoUsuario(), usuario.getCorreo(), usuario.getHabitaciones_numeroHabitacion().getNumeroHabitacion());
        return "redirect:/usuarios";
    }

    @GetMapping("/bares/{id}/delete")
    public String barEliminar(@PathVariable("id") int id) {
        usuarioRepository.eliminarUsuario(id);
        return "redirect:/usuarios";
    }

}