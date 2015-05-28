/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.struts.action;

import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.ORM.*;
import com.base.*;
import com.service.*;
import com.struts.form.MemLoginForm;

/** 
 * MyEclipse Struts
 * Creation date: 09-13-2007
 * 
 * XDoclet definition:
 * @struts.action path="/login" name="memLoginForm" input="/default.jsp" parameter="method" scope="request" validate="true"
 */
public class LoginAction extends BaseAction {
	/*
	 * Generated Methods
	 */

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		MemLoginForm memLoginForm = (MemLoginForm) form;
		MemService service = new MemServiceImpl();
		ActionForward forward = null;
		ActionMessages msgs = new ActionMessages();
		try{
			Member mem = service.memLogin(memLoginForm.getLoginName(), memLoginForm.getLoginPwd());
			if (mem!=null){
				request.getSession().setAttribute("member", mem);
				forward = new ActionForward("/mer.do?method=browseIndexMer");
			}else{				
				forward = mapping.getInputForward();
				msgs.add("loginError",new ActionMessage(Constants.ADMIN_LOGINERROR_KEY));
				saveErrors(request, msgs);
			}
		}catch(Exception ex){
			logger.info("在执行LoginAction类中的login方法时出错：\n");
			ex.printStackTrace();
		}
		return forward;
	}
	
	public ActionForward logout(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		request.getSession().removeAttribute("member");
		return new ActionForward("/mer.do?method=browseIndexMer");
	}	
}