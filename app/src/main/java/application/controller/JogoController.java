package application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import application.model.Jogo;
import application.repository.JogoRepository;

@RestController
@RequestMapping("/jogos")
public class JogoController {
    @Autowired
    private JogoRepository jogoRepo;

    @GetMapping
    public Iterable<Jogo> getAll() {
        return jogoRepo.findAll();
    }

    @PostMapping
    public Jogo post(@RequestBody Jogo jogo) {
        return jogoRepo.save(jogo);
    }

    @GetMapping("/{id}")
    public Jogo getOne(@PathVariable long id) {
        Optional<Jogo> resultado = jogoRepo.findById(id);
        if(resultado.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Jogo não encontrado"
            );
        }
        return resultado.get();
    }

    @PutMapping("/{id}")
    public Jogo put(@PathVariable long id, @RequestBody Jogo novosDados){
        Optional<Jogo> resultado = jogoRepo.findById(id);

        if(resultado.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Jogo não encontrado"
            );
        }

        resultado.get().setNome(novosDados.getNome());
        resultado.get().setCategoria(novosDados.getCategoria());

        return jogoRepo.save(resultado.get());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        if(!jogoRepo.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Jogo não encontrado"
            );
        }

        jogoRepo.deleteById(id);
    }
}