package br.com.apiduxcod3.service;

import br.com.apiduxcod3.entity.Produto;
import br.com.apiduxcod3.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService implements IProdutoService{

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }


    @Override
    public Optional<Produto> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }

    @Override
    public List<Produto> buscarTodos() {
        return produtoRepository.findAll();
    }

    @Override
    public void alterar(Produto produto) {
        if (produto.getId() == null) {
            throw new IllegalArgumentException("O ID do produto não pode ser nulo para a operação de alteração.");
        }

        Produto produtoExistente = produtoRepository.findById(produto.getId()).orElseThrow(() -> new EntityNotFoundException("Produto não encontrado com o ID fornecido."));

        produtoExistente.setNome(produto.getNome());
        produtoExistente.setValor(produto.getValor());
        produtoExistente.setDescricao(produto.getDescricao());

        produtoRepository.save(produtoExistente);
    }

    @Override
    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public void deletar(Long id) {
        try {
               produtoRepository.deleteById(id);
        } catch (Exception ex) {
            throw new RuntimeException("Ocorreu um erro ao excluir o produto!");
        }
    }
}