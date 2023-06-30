/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.73
 * Generated at: 2023-04-07 04:17:40 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp._09PagingBoard;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import board.BoardDAO;
import board.BoardDTO;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import utils.pagingUtil;

public final class List_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("utils.pagingUtil");
    _jspx_imports_classes.add("board.BoardDAO");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("board.BoardDTO");
    _jspx_imports_classes.add("java.util.Map");
    _jspx_imports_classes.add("java.util.HashMap");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
 
	BoardDAO dao = new BoardDAO(application);
	
	String findCol= request.getParameter("findCol");
	String findWord= request.getParameter("findWord");

	Map<String, Object> param = new HashMap<String, Object>();
	if(findWord!=null)
	{
		param.put("findCol",findCol);
		param.put("findWord",findWord);
		
	}
	
	int totalCount = dao.getTotalCount(param);
	
	int pageSize=Integer.parseInt(application.getInitParameter("PAGE_SIZE"));
	int blockSize=Integer.parseInt(application.getInitParameter("PAGING_BLOCK"));
	int totalPage=(int)Math.ceil((double)totalCount/pageSize);
	
	int pageNum=1;
	String pageTemp=request.getParameter("pageNum");
	if(pageTemp!=null && !pageTemp.equals("")){
		pageNum=Integer.parseInt(pageTemp);		
	}
	//표시할 게시물의 시작과 끝 번호 값 계산
	int start=(pageNum-1)*pageSize+1;
	int end=pageNum*pageSize;
	param.put("start",start);
	param.put("end",end);
	
	List<BoardDTO> boardLists = dao.getListPage(param);
	dao.close();
	
	/*List<BoardDTO> boardLists=dao.getList(findCol,findWord);  */

	
	


      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>목록</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../common/Top.jsp", out, false);
      out.write("\r\n");
      out.write("	<h2>목록 보기</h2>\r\n");
      out.write("	<!-- 검색(자기 자신에서 검색창이 뜨기에 ACTION이 따로 구현할 필요없다) -->\r\n");
      out.write("		<form  method=\"get\">\r\n");
      out.write("			<table border= \"1\" width=\"90%\">\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td align=\"center\">\r\n");
      out.write("						<select name=\"findCol\">\r\n");
      out.write("							<option value=\"title\">제목</option>\r\n");
      out.write("							<option value=\"content\">내용</option>\r\n");
      out.write("						</select>\r\n");
      out.write("						<input type=\"text\" name=\"findWord\"/>\r\n");
      out.write("						<input type=\"submit\" value=\"검색\"/>\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("			</table>\r\n");
      out.write("		</form>\r\n");
      out.write("		<!-- 목록 -->\r\n");
      out.write("		<table border= \"1\" width=\"90%\">\r\n");
      out.write("			<tr>\r\n");
      out.write("				<th>번호</th><th>제목</th><th>작성자</th><th>조회수</th><th>작성일</th>\r\n");
      out.write("			</tr>\r\n");
      out.write("		");

			//게시물에 내용물이 없으면
			if(boardLists.isEmpty())
			{
		
		
      out.write("\r\n");
      out.write("			<tr>\r\n");
      out.write("				<td colspan = \"5\" align=\"center\">등록된 게시물이 없습니다.</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("		");

			//게시물에 내용물이 있으면 클릭시 뷰를 나오게 할려는 목적
			}else{
				for(BoardDTO dto:boardLists)
				{
		
      out.write("\r\n");
      out.write("			<tr align=\"center\">\r\n");
      out.write("				<td align=\"center\">");
      out.print(dto.getNum() );
      out.write("</td>\r\n");
      out.write("				<td align=\"Left\">\r\n");
      out.write("					<a href = \"View.jsp?num=");
      out.print(dto.getNum() );
      out.write('"');
      out.write('>');
      out.print(dto.getTitle() );
      out.write("</a>\r\n");
      out.write("				</td>\r\n");
      out.write("				<td align=\"center\">");
      out.print(dto.getId() );
      out.write("</td>\r\n");
      out.write("				<td align=\"center\">");
      out.print(dto.getVisitcount() );
      out.write("</td>\r\n");
      out.write("				<td align=\"center\">");
      out.print(dto.getPostdate() );
      out.write("</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("		\r\n");
      out.write("		");

				}
				
			}
		
      out.write("\r\n");
      out.write("		</table>\r\n");
      out.write("		<table border=\"1\" width=\"90%\">\r\n");
      out.write("			<tr align=\"center\">\r\n");
      out.write("				<td>\r\n");
      out.write("				");
      out.print(pagingUtil.pagingBlock(totalCount, pageSize, blockSize, pageNum, request.getRequestURI()) );
      out.write("\r\n");
      out.write("				</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("		</table>\r\n");
      out.write("		<br>\r\n");
      out.write("		<div align=\"center\">\r\n");
      out.write("         <button type=\"button\" onclick=\"location.href='Write.jsp';\">글쓰기</button>\r\n");
      out.write("         \r\n");
      out.write("     	 </div>\r\n");
      out.write("		\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
