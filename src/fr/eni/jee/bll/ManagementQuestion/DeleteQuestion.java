package fr.eni.jee.bll.ManagementQuestion;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.jee.bo.Question;
import fr.eni.jee.dal.QuestionDAO;

/**
 * Servlet implementation class DeleteQuestion
 */
@WebServlet("/Formateur/deleteQuestion")
public class DeleteQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/Former/ManagementQuestion/ListQuestion.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteQuestion() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Question question = new Question();
		question.setId(Integer.parseInt(request.getParameter("id")));

		try {
			QuestionDAO.Delete(question);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		List<Question> lstQuestion = new ArrayList<Question>();

		try {
			lstQuestion = QuestionDAO.GetAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("lstQuestion", lstQuestion);

		this.getServletContext().getRequestDispatcher(VIEW).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher(VIEW).forward(request, response);
	}

}
