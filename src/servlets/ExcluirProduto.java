package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Produto;
import service.ProdutoService;

/**
 * Servlet implementation class ExcluirProduto
 */
@WebServlet(name = "ExcluirProduto.do", urlPatterns = { "/ExcluirProduto.do" })
public class ExcluirProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter saida = response.getWriter();

		String parameterCodigo = request.getParameter("codigo_pro");
		int codigo;

		if (parameterCodigo == "" || parameterCodigo == null || parameterCodigo.length() <= 0
				|| parameterCodigo.isEmpty()) {
			saida.println("<h1>Volte e informe o código do produto!</h1>");
			saida.println("<br>");
			saida.println("<a href='alteracao.html'>Voltar</a>");
			return;
		} else {
			codigo = Integer.parseInt(parameterCodigo);
		}
		
		Produto produto = new Produto();
		produto.setCodigo(codigo);

		ProdutoService produtoService = new ProdutoService();
		Produto existe = produtoService.consultar(codigo);
		
		if (!existe.isValid()) {
			saida.println("<h1>Produto não encontrado.</h1>");
		} else {
			produtoService.excluir(produto);
			saida.println("<h1>Produto excluído com sucesso!</h1>");
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
