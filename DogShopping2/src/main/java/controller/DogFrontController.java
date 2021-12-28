package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.DogCartAddAction;
import action.DogCartListAction;
import action.DogCartQtyDownAction;
import action.DogCartQtyUpAction;
import action.DogCartRemoveAction;
import action.DogCartSearchAction;
import action.DogListAction;
import action.DogRegistAction;
import action.DogRegistFormAction;
import action.DogViewAction;
import vo.ActionForward;

// ��� Ŭ���̾�Ʈ�� ��û�� �޾Ƽ� �����ϴ� ��Ʈ�ѷ� Ŭ������
@WebServlet("*.dog")
public class DogFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. ��û �ľ�
		String requestURI = request.getRequestURI();
		// ��û url : http://localhost:9000/DogShopping/*.dog
		String contextPath = request.getContextPath();

		String command = requestURI.substring(contextPath.length());
		Action action = null;
		ActionForward forward = null;

		// 2. �� ��û���� ����Ͻ� ���� ȣ��
		if (command.equals("/dogList.dog")) {
			action = new DogListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/dogRegist.dog")) {
			action = new DogRegistAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/dogRegistForm.dog")) {
			action = new DogRegistFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		else if (command.equals("/dogView.dog")) {
			action = new DogViewAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		else if (command.equals("/dogCartADD.dog")) {
			action = new DogCartAddAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		else if (command.equals("/dogCartList.dog")) {
			action = new DogCartListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		else if (command.equals("/dogCartQtyUp.dog")) {
			action = new DogCartQtyUpAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		else if (command.equals("/dogCartQtyDown.dog")) {
			action = new DogCartQtyDownAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		else if (command.equals("/dogCartRemove.dog")) {
			action = new DogCartRemoveAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/dogCartSearch.dog")) {
			action = new DogCartSearchAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		if (forward != null) {

			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}

	}
}
