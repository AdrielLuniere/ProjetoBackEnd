package com.teste.projeto_backend.controller;
import org.springframework.web.bind.annotation.RestController;


@RestController 
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired 
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> obterTodos() {
        return produtoService.obterTodos();
    }
    
}