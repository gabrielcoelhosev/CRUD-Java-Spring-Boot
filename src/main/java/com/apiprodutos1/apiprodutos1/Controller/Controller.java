package com.apiprodutos1.apiprodutos1.Controller;

import com.apiprodutos1.apiprodutos1.domain.Produtos;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*")
public class Controller {

    private List<Produtos> listaProdutos = new ArrayList<>();

    @PostMapping("")
    public String produtosPost(@RequestBody Produtos body){
        listaProdutos.add(body);
        return "Produto adicionado: " + body.getNome();
    }

    @GetMapping("")
    public List<Produtos> getListaProdutos(){
        return listaProdutos;
    }

    @DeleteMapping("/{id}")
    public String produtosDelete(@PathVariable int id){
        for (Produtos produto: listaProdutos){
            if (produto.getId() == id){
                listaProdutos.remove(produto);
                return "Produto removido com sucesso: ID " + id;
            }
        }
        return "Produto não encontrado: " + id;
    }

    @PutMapping("/{id}")
    public String produtosPut(@PathVariable int id, @RequestBody Produtos body){
        for (Produtos produto: listaProdutos){
            if (produto.getId() == id){
                produto.setNome(body.getNome());
                produto.setPreco(body.getPreco());
                return "Produto atualizado: " + body.getNome();
            }
        }
        return "Produto não encontrado com ID: " + id;
    }
}
