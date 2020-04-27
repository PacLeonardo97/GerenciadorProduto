package service;

import java.util.ArrayList;

import dao.ProdutoDAO;
import model.Produto;

public class ProdutoService {
	private ProdutoDAO produtoDAO;

	public ProdutoService() {
		this.produtoDAO = new ProdutoDAO();
	}

	public void cadastrar(Produto produto) {
		this.produtoDAO.cadastrar(produto);
	}

	public void alterar(Produto produto) {
		this.produtoDAO.alterar(produto);
	}

	public void excluir(Produto produto) {
		this.produtoDAO.excluir(produto);
	}

	public Produto consultar(int codigo) {
		return this.produtoDAO.consultar(codigo);
	}

	public ArrayList<Produto> listarProdutos() {
		return this.produtoDAO.listarProdutos();
	}
}
