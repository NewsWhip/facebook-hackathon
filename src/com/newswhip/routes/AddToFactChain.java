package com.newswhip.routes;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import com.newswhip.pojo.FactChainWrapper;
import com.newswhip.service.FactChainService;
import com.newswhip.service.FactChainService.HashCodeKeys;

/**
 * Servlet implementation class AddToFactChain
 */
public class AddToFactChain extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static FactChainService factChainService = new FactChainService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddToFactChain() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Object factChainObject = request.getAttribute("addToFactChainObject");

		long lastHash = 0l;

		if (request.getSession().getAttribute("lastHash") != null) {
			lastHash = (long) request.getSession().getAttribute("lastHash");
		}

		String lastAddress = "";

		if (request.getSession().getAttribute("lastAddress") != null) {
			lastAddress = (String) request.getSession().getAttribute(
					"lastAddress");
		}

		Timestamp creationTime = new Timestamp(
				new DateTime(DateTimeZone.UTC).getMillis());

		HashCodeKeys hashCodeKeys = factChainService
				.hashFactChain(factChainObject);

		// build the wrapper

		FactChainWrapper factChainWrapper = new FactChainWrapper(
				hashCodeKeys.gethCode(), lastHash, lastAddress, creationTime);

		factChainService.writeFileToDisk(factChainWrapper,
				Long.toString(lastHash));

		request.getSession().setAttribute("lastHash", hashCodeKeys.gethKey());

	}
}
