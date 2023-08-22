package br.com.apiduxcod3.service;

import br.com.apiduxcod3.entity.Produto;
import java.util.List;
import java.util.Optional;

public interface IProdutoService {
    Optional<Produto> buscarPorId(Long id);
    List<Produto> buscarTodos();
    void alterar(Long id,Produto produto);
    Produto salvar(Produto produto);
    void deletar(Long id);
}