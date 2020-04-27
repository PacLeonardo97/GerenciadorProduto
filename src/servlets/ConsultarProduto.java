package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Produto;
import service.ProdutoService;

/**
 * Servlet implementation class ConsultarProduto
 */
@WebServlet(name = "ConsultarProduto.do", urlPatterns = { "/ConsultarProduto.do" })
public class ConsultarProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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

		ProdutoService produtoService = new ProdutoService();
		Produto resultado = produtoService.consultar(codigo);

		if (!resultado.isValid()) {
			saida.println("<h1>Produto não encontrado.</h1>");
		} else {
			NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
			saida.println("<h1>Dados do produto:</h1>");
			saida.println("<p><b>Código: </b>" + resultado.getCodigo() + "</p>");
			saida.println("<p><b>Nome: </b>" + resultado.getNome() + "</p>");
			saida.println("<p><b>Descrição: </b>" + resultado.getDescricao() + "</p>");
			saida.println("<p><b>Valor: </b>" + numberFormat.format(resultado.getValor()) + "</p>");
			saida.println("<p><b>Estoque: </b>" + resultado.getEstoque() + "</p>");
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
