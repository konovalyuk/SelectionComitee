package com.bionicuniversity.tlds;

import java.io.IOException;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;

import com.bionicuniversity.manager.MessageManager;

public class IndexTld extends SimpleTagSupport {

	public void doTag() throws JspException {

		try {
			JspWriter out = getJspContext().getOut();
			
			String header = MessageManager.getInstance().getProperty(MessageManager.INDEX_HEADER);
			String content = MessageManager.getInstance().getProperty(MessageManager.INDEX_CONTENT);

			out.write("<h1>" + header + "</h1>");
			out.write("<p>" + content + "</p>");

		} catch (IOException ex) {
			throw new JspException(ex.getMessage());
		}
	}
}