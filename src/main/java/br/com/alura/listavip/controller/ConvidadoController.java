package br.com.alura.listavip.controller;

import br.com.alura.listavip.dto.ConvidadoDTO;
import br.com.alura.listavip.service.ConvidadoService;
import br.com.alura.listavip.service.EmailService;
import br.com.alura.listavip.model.Convidado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvidadoController {

    @Autowired
    private ConvidadoService convidadoService;
    @Autowired
    private EmailService emailService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/listaconvidados")
    public String listaConvidados(Model model) {
        Iterable<Convidado> convidados = convidadoService.obterTodos();

        model.addAttribute("convidados", convidados);

        return "listaconvidados";
    }

    @PostMapping(value = "salvar")
    public String salvar(ConvidadoDTO dto, Model model) {
        convidadoService.salvar(convidadoService.createConvidado(dto));
        emailService.enviar(dto.getNome(), dto.getEmail());

        return listaConvidados(model);
    }

    @DeleteMapping(value = "excluir")
    public String excluir(@RequestParam("id") Long id, Model model) {
        convidadoService.excluir(id);

        return listaConvidados(model);
    }

}
