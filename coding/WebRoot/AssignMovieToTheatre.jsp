
<%@page import="java.util.ArrayList"%>
<%@page import="com.kws.mtrs.bean.MovieBean"%>
<%@page import="com.kws.mtrs.dao.MoviesDAO"%>
<%@page import="com.kws.mtrs.bean.TheatreBean"%>
<%@page import="com.kws.mtrs.dao.TheatreDAO"%>
<%@page import="javax.servlet.jsp.tagext.IterationTag"%>
<%@page import="java.util.Iterator"%><!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
	<head>

		<title>Movie Ticket Reservation System</title>
		<script type="text/javascript" src="scripts/mm_menu.js"> </script>
		<link type="text/css" rel="stylesheet" href="images/style.css"
			id="livezilla_style" />
		<script src="images/a" id="livezilla_geoscript"></script>
		<script type="text/javascript">
		 function checkForm(){
			if(){
			}
		}
		</script>
	</head>

	<body>
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tbody>
				<tr>
					<td colspan="2">
						<style type="text/css">
.top-link-logout {
	color: #f2e60e;
	text-decoration: none;
}

.top-link-logout:hover {
	color: #f2e60e;
	text-decoration: underline;
}
</style>

						<table width="100%" border="0" cellpadding="0" cellspacing="0">
							<tbody>
								<tr>
									<td valign="top" align="left" background="images/top-bg.jpg"
										height="174">
										<table width="100%" border="0" cellpadding="0" cellspacing="0">
											<tbody>
												<tr>
													<td valign="top" width="38" align="left" height="174">
														&nbsp;
													</td>
													<td valign="top" width="253" align="left">
														<img src="images/logo.jpg" style="border: 0px none;"
															width="211" height="163" />
													</td>
													<td valign="top" width="105" align="left">
														<img id="movies" name="movies" src="images/movies-on.jpg"
															width="105" border="0" height="123" />
													</td>
													<td valign="top" width="198" align="left">
														<img id="plays" name="plays" src="images/book-abirami.JPG"
															width="198" border="0" height="123" />
													</td>
													<td valign="top" width="104" align="left">
														<img id="matches" name="matches"
															src="images/matches-off.jpg" width="104" border="0"
															height="123" />
													</td>

													<td valign="top" width="104" align="left">
														<img id="Img1" name="matches"
															src="images/event-limata09.gif" width="81" border="0"
															height="123" />
													</td>
													<td valign="top" width="34" align="left">
														&nbsp;
													</td>

													<td valign="top" align="left">
														<a class="top-link" href="#"></a>

														<a class="top-link" href="index.jsp">Home</a>
														<img src="images/top-link-div.gif" width="1" height="12"
															hspace="7" />
														<a class="top-link" href="LoginForm.jsp">Sign In</a>
														<img src="images/top-link-div.gif" width="1" height="12"
															hspace="7" />

														<a class="top-link" href="Register.jsp">Register</a>


														<div id="right-div 123">
															<span class="yellow">Welcome: </span><span
																class="yellow-bold"> Guest </span>
														</div>
													</td>
													<td valign="top" align="left">
														&nbsp;
													</td>
												</tr>
											</tbody>
										</table>
									</td>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>
				<tr>
					<td valign="top" align="left" bgcolor="#00458f">
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
							<tbody>
								<tr>
									<td valign="top" width="26" align="left">
										&nbsp;
									</td>
									<td valign="top" align="left">


										<link href="images/LimataStyleSheet.css" rel="stylesheet"
											type="text/css" />

										<!-- style for progress bar starts here ...-->

										<table width="100%" border="0" cellpadding="0" cellspacing="0">
											<tbody>
												<tr>
													<td>
														<a href="http://www.limata.com/index.aspx"><img alt=""
																src="images/limata-counter.jpg"
																style="vertical-align: bottom;" width="257" border="0"
																height="124" /> </a>
													</td>
												</tr>

												<tr>
													<td>

														<img src="images/call-delivery.jpg"
															style="text-align: center; width: 257px; height: 149px;"
															alt="" />
													</td>
												</tr>
											</tbody>
										</table>

										<div id="Limata_Counter1_updateProgress"
											style="display: none;">

											<div id="progressBackgroundFilter"
												style="left: 0px; top: 0px;">
											</div>
											<div id="processMessage">
												<table width="100%" border="0" cellpadding="0"
													cellspacing="0">

													<tbody>
														<tr>
															<td align="left">
																<img alt="Loading"
																	src="images/progressbar_microsoft.gif" />
															</td>
														</tr>
													</tbody>
												</table>
											</div>

										</div>
									</td>

									<td valign="top" width="4" align="left">
									</td>
									<td valign="top">
										<table width="100%" border="0" cellpadding="0" cellspacing="0">
											<tbody>
												<tr valign="middle" align="center">
													<td background="images/changing-tab.jpg" height="59"
														style="font-size: 20px; font-weight: bold; color: White; margin-bottom: 0px; margin-top: 0px; text-align: center;">
														<jsp:include page="AdminOptions.jsp"></jsp:include>
													</td>
												</tr>
												<tr>
													<td valign="top" align="left"
														background="images/middle-line-tile.gif">
														<table width="100%" border="0" cellpadding="0"
															cellspacing="0">
															<tbody>
																<tr>
																	<td valign="top" align="left">
																		<table width="100%" border="0" cellpadding="0"
																			cellspacing="0">
																			<tbody>
																				<tr>

																					<td valign="top" width="50" align="center">
																						<br />
																					</td>
																					<td valign="top" align="left">
																						<br />
																						<h1
																							style="font-size: 20px; font-weight: bold; color: red; margin-bottom: 0px; margin-top: 0px; text-align: center;">
																							E-Movie Tickets
																						</h1>
																					</td>

																				</tr>
																			</tbody>
																		</table>
																	</td>
																</tr>
																<tr>
																	<td valign="top" align="left">
																	 <form action="./AssignMovieToTheatre" method="get">
																		<table width="100%" border="0" cellpadding="0"
																			cellspacing="0">
																			<tbody>
																			
																				<tr>
																					<td style="width: 6px;" valign="top" align="left">
																						<img src="images/vert-line-left-2.jpg" width="6"
																							height="274" />
																					</td>
																					<td valign="top" width="28" align="left">
																						&nbsp;
																					</td>
																					<td valign="middle" width="631" align="center"
																						background="images/green-box.jpg" height="274">
																					<%
                                                                                      ArrayList<MovieBean> mbean=new MoviesDAO().getMovies();
                                                                                      ArrayList<TheatreBean> tbean=new TheatreDAO().getTheatres();
                                                                                     %>
                                                                                     <form method="get" action="./AssignMovieToTheatre" onsubmit="return checkForm();">
																						<table>
																						 <tr>
																			 <td colspan="2" align="center">
																			 <font color=red>
																			  <%if(request.getParameter("status")!=null){
																			    out.println(request.getParameter("status"));
																			  } %></font>
																			 </td>
																			</tr>
																							<tr>
																								<td>
																									Theatre Name:
																								</td>
																								<td>
																									<select name="tid">
																						  <%
																						  Iterator<TheatreBean> titr=tbean.iterator();
																					       while(titr.hasNext())
																					       {
																					          TheatreBean tb=titr.next();
																					      %>
																					       <option value="<%=tb.getTheatreid() %>"><%=tb.getTheatrename() %></option>
																					      <%} %>

																							</select>
																							</td>
																							</tr>
																							<tr>
																								<td>
																									Movie Name:
																								</td>
																								<td>
																							    <select name="mid">
																						  <%
																					     
																					       Iterator<MovieBean> mitr=mbean.iterator();
																					       while(mitr.hasNext())
																					       {
																					          MovieBean tb=mitr.next();
																					       %>
																					       <option value="<%=tb.getMovieid() %>"><%=tb.getMoviename() %></option>
																						   <%} %>
																							</select>
																							</td>
																							</tr>
																							<tr>
																							 <td>
																							  Timings
																							 </td>
																							 <td>
																							  <input name="timings" type="text"/>
																							 </td>
																							</tr>
																							<tr>
																							 <td>
																							  Ticket Price
																							 </td>
																							 <td>
																							  <input name="price" type="text"/>
																							 </td>
																							</tr>
																							<tr>
																							 <td colspan="2" align="center">
																							  <input type="submit" value="SUBMIT"/>
																							 </td>
																							</tr>
																						</table>
																						</form>
																					</td>
																					<td valign="top" align="left">
																						&nbsp;
																					</td>
																					<td valign="top" width="7" align="left">
																						<img src="images/vert-line-right-2.jpg" width="7"
																							height="274" />
																					</td>
																				</tr>
																			</tbody>
																		</table>
																	  </form>
																	</td>
																</tr>
															</tbody>
														</table>
													</td>
												</tr>
											</tbody>
										</table>
									</td>
									<td valign="top" width="23" align="left">
										&nbsp;
									</td>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>
				<tr>
					<td colspan="2">


						<table width="100%" border="0" cellpadding="0" cellspacing="0">

							<tbody>
								<tr>
									<td width="200" align="center" background="images/foot-bg.jpg">

									</td>
									<td class="foot" valign="middle" align="center"
										background="images/foot-bg.jpg" height="99">
										<br />
									</td>
									<td width="200" background="images/foot-bg.jpg">
										&nbsp;
									</td>
								</tr>
							</tbody>
						</table>


					</td>
				</tr>
			</tbody>
		</table>
	</body>
</html>