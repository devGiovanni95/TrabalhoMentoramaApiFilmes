package br.com.mentorama.apiFilmes.services;

import br.com.mentorama.apiFilmes.entities.Filmes;
import br.com.mentorama.apiFilmes.repositories.FilmesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmesService implements IFilmesService{

    @Autowired
    private FilmesRepository filmesRepository;

    public List<Filmes> findAll(Filmes filmes){
        if (filmes != null){
            return filmesRepository.findAll(filmes);
        }
        return filmesRepository.findAll();
    }

    public Filmes findId(Integer id) {
        return filmesRepository.findId(id);
    }

    public Filmes add(final Filmes filmes){
        return filmesRepository.addFilme(filmes);
    }

    public void updateName(final Filmes nome){
        filmesRepository.updateNome(nome);
    }

    public void updateDiretor(final Filmes diretor){
        filmesRepository.updateDiretor(diretor);
    }

    public void updateAno(final Filmes ano){
        filmesRepository.updateAno(ano);
    }

    public void updateNota(final Filmes nota){
        filmesRepository.updateNota(nota);
    }


    public void delete(Integer id) {
        filmesRepository.delete(id);
    }

}
