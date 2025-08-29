package com.teste.projeto_backend.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.InputMismatchException;
import com.teste.projeto_backend.model.Produto;
import org.springframework.stereotype.Repository;

@Repository
public class ProdutoRepository {

    private List<Produto> produtos = new ArrayList<Produto>();
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
     * @return Optional contendo o produto, ou vazio se não encontrado
     */
    public Optional<Produto> obterPorId(Integer id){
        return produtos.stream().filter(produto -> produto.getId() == id).findFirst();
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

    /**
     * Metodo para deletar o produto por id.
     * @param id do produto a ser deletado
     *
     */
    public void deletar(Integer id){
        produtos.removeIf(produto -> produto.getId() == id);
    }

    /**
     * Atualiza um produto existente na lista.
     *
     * @param produto produto com os dados atualizados
     * @return produto atualizado
     * @throws InputMismatchException se o produto com o ID especificado não for encontrado
     */
    public Produto atualizar(Produto produto){
        Optional<Produto> produtoExistente = obterPorId(produto.getId());

        if(produtoExistente.isEmpty()){
            throw new InputMismatchException("Produto com ID " + produto.getId() + " não encontrado.");
        }

        deletar(produto.getId());
        produtos.add(produto);
        return produto;
    }
       
}