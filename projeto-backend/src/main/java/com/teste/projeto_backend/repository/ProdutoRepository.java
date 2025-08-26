package com.teste.projeto_backend.repository;

import java.util.Arraylist;
import java.util.List;
import com.teste.projeto_backend.model.Produto;
import org.springframework.stereotype.Repository;

@Repository
public class ProdutoRepository {

    private List<Produto> produtos = new Arraylist<Produto>();
    private Integer ultimoId = 0;

    /**
     * Retorna a lista de todos os produtos cadastrados.
     *
     * @return lista de produtos
     */
    public List<Produto> obterTodos(){
        return produtos;
    }

    /**
     * Retorna o produto com o ID especificado.
     *
     * @param id ID do produto a ser obtido
     * @return produto com o ID especificado, ou null se não encontrado
     */
    public Produto obterPorId(Integer id){
        return produtos.stream().filter(produto -> produto.getId() ==id).findFirst();
    }
    /**
     * Adiciona um novo produto à lista.
     *
     * @param produto produto a ser adicionado
     * @return produto adicionado com o ID atualizado
     */
    public Produto adicionar(Produto produto){
        ultimoId++;
        produto.setId(ultimoId);
        produtos.add(produto);
        return produto;
    }
}