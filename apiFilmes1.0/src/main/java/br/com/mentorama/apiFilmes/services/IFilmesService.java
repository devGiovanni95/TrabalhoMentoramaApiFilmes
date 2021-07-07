package br.com.mentorama.apiFilmes.services;

import br.com.mentorama.apiFilmes.entities.Filmes;

import java.util.List;

public interface IFilmesService {

    List<Filmes> findAll(Filmes filmes);

    Filmes findId(Integer id);

    Filmes add(final Filmes filmes);

    void updateName(final Filmes nome);
    void updateDiretor(final Filmes diretor);
    void updateAno(final Filmes ano);
    void updateNota(final Filmes nota);
    void delete(Integer id);
}
