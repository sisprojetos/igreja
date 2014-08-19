package br.com.sis.igreja.util;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(servletNames = {"Faces Servlet"})
public class JPAFilter implements Filter {
	
	private EntityManager em;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		em = JPAUtil.getEntityManager();
	}

	@Override
	public void destroy() {
		em.close();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		// CHEGADA
		em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		// CHEGADA

		// FACES SERVLET
		chain.doFilter(request, response);
		// FACES SERVLET

		// SAÍDA
		try {
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		// SAÍDA
	}
}