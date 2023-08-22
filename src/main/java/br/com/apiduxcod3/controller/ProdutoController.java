package br.com.apiduxcod3.controller;

import br.com.apiduxcod3.entity.Produto;
import br.com.apiduxcod3.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Optional<Produto>> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(produtoService.buscarPorId(id));
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Produto>> buscarTodos() {
        return ResponseEntity.ok(produtoService.buscarTodos());
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<Void> alterar(@PathVariable Long id, @RequestBody Produto produto) {
        produtoService.alterar(id,produto);
        return ResponseEntity.ok().build();
    }


    @PostMapping("/salvar")
    public ResponseEntity<Produto> salvar(@RequestBody Produto produto) {
    var novoProduto = produtoService.salvar(produto);
    return new ResponseEntity(novoProduto,HttpStatus.CREATED);
    }

    @DeleteMapping("deletar/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        produtoService.deletar(id);
        return ResponseEntity.ok().build();
    }
}