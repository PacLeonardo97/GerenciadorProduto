package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Produto;
import service.ProdutoService;

/**
 * Servlet implementation class ListarProdutos
 */
@WebServlet(name = "ListarProdutos.do", urlPatterns = { "/ListarProdutos.do" })
public class ListarProdutos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
	
		ProdutoService produtoService = new ProdutoService();
		ArrayList<Produto> produtos = produtoService.listarProdutos();
		PrintWriter saida = response.getWriter();
		
		saida.println("<h1>Produtos cadastrados:</h1>");
		if (produtos.isEmpty()) {
			saida.println("<p>Não há produtos cadastrados.</p>");
		} else {
			NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
			for (Produto produto : produtos) {
				saida.println("<p><b>Código: </b>" + produto.getCodigo() + "</p>");
				saida.println("<p><b>Nome: </b>" + produto.getNome() + "</p>");
				saida.println("<p><b>Descrição: </b>" + produto.getDescricao() + "</p>");
				saida.println("<p><b>Valor: </b>" + numberFormat.format(produto.getValor()) + "</p>");
				saida.println("<p><b>Estoque: </b>" + produto.getEstoque() + "</p>");
				saida.println("<hr>");
			}
		}

		saida.println("<a href=\"cadastro.html\">Cadastrar produto</a>");
		saida.println("<br>");
		saida.println("<br>");
		saida.println("<a href=\"alteracao.html\">Alterar produto</a>");
		saida.println("<br>");
		saida.println("<br>");
		saida.println("<a href=\"excluir.html\">Excluir produto</a>");
		saida.println("<br>");
		saida.println("<br>");
		saida.println("<a href=\"consultar.html\">Consultar produto</a>");
		saida.println("<br>");
		saida.println("<br>");
		saida.println("<a href=\"ListarProdutos.do\">Listar produtos</a>");
	}

}
