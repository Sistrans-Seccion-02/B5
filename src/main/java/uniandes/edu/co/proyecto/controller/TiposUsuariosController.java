package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.TipoUsuario;
import uniandes.edu.co.proyecto.repositorio.TipoUsuarioRepository;

@Controller
public class TiposUsuariosController {

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    @GetMapping("/tiposUsuario")
    public String tiposUsuario(Model model) {
        model.addAttribute("tiposUsuario", tipoUsuarioRepository.darTiposUsuario());
        return "tiposUsuario";
    }

    @GetMapping("/tiposUsuario/new")
    public String tipoUsuarioForm(Model model) {
        model.addAttribute("tipoUsuario", new TipoUsuario());
        return "tipoUsuarioNuevo";
    }

    @PostMapping("/tiposUsuario/new/save")
    public String tipoUsuarioGuardar(@ModelAttribute TipoUsuario tipoUsuario) {
        tipoUsuarioRepository.insertarTipoUsuario(tipoUsuario.getTipoUsuario());
        return "redirect:/tiposUsuario";
    }

    @GetMapping("/tiposUsuario/{tipoUsuario}/edit")
    public String tipoUsuarioEditarForm(@PathVariable("tipoUsuario") String pktipoUsuario, Model model) {
        TipoUsuario tipoUsuario = tipoUsuarioRepository.darTipoUsuario(pktipoUsuario);
        if (tipoUsuario != null) {
            model.addAttribute("tipoUsuario", tipoUsuario);
            return "tipoUsuarioEditar";
        } else {
            return "redirect:/tiposUsuario";
        }
    }

    @PostMapping("/tiposUsuario/{tipoUsuario}/edit/save")
    public String tipoUsuarioEditarGuardar(@PathVariable("tipoUsuario") String pktipoUsuario, @ModelAttribute TipoUsuario tipoUsuario) {
        tipoUsuarioRepository.actualizarTipoUsuario(pktipoUsuario, tipoUsuario.getTipoUsuario());
        return "redirect:/tiposUsuario";
    }
    // #TODO
    // @GetMapping("/bares/{id}/delete")
    // public String barEliminar(@PathVariable("id") long id) {
        // barRepository.eliminarBar(id);
        // return "redirect:/bares";
    // }
}
