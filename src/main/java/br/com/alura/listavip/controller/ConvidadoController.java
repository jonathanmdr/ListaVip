package br.com.alura.listavip.controller;

import br.com.alura.listavip.dto.ConvidadoDTO;
import br.com.alura.listavip.service.ConvidadoService;
import br.com.alura.listavip.service.EmailService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestScope
public class ConvidadoController {

    @Autowired
    private ConvidadoService convidadoService;
    @Autowired
    private EmailService emailService;

    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @RequestMapping("/listaconvidados")
    public ModelAndView listaConvidados() {
        ModelAndView view = new ModelAndView("listaconvidados");
        view.addObject("convidados", convidadoService.findAll());

        return view;
    }

    @RequestMapping("/cadastro")
    public ModelAndView cadastroConvidados(ConvidadoDTO dto) {
        ModelAndView view = new ModelAndView("cadastro");
        view.addObject("convidado", convidadoService.dtoToConvidado(dto));

        return view;
    }

    @PostMapping("/salvar")
    public ModelAndView salvar(@Valid ConvidadoDTO dto, BindingResult result) {
        if (result.hasErrors()) {
            return cadastroConvidados(dto);
        }

        convidadoService.salvar(convidadoService.dtoToConvidado(dto));

        if (convidadoService.sendEmail(dto)) {
            emailService.enviar(dto.getNome(), dto.getEmail());
        }

        return new ModelAndView("redirect:/listaconvidados");
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable("id") Long id) {
        return cadastroConvidados(convidadoService.convidadoToDto(convidadoService.findById(id)));
    }

    @GetMapping("/excluir/{id}")
    public ModelAndView excluir(@PathVariable("id") Long id) {
        convidadoService.excluir(id);

        return new ModelAndView("redirect:/listaconvidados");
    }

}
