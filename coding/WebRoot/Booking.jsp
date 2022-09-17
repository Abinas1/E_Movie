
<%@page import="com.kws.mtrs.dao.BookingDAO"%><!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
	<head>

		<title>Movie Ticket Reservation System</title>
		<script type="text/javascript" src="scripts/mm_menu.js"> </script>
		<link type="text/css" rel="stylesheet" href="images/style.css"
			id="livezilla_style" />
		<script src="images/a" id="livezilla_geoscript"></script>
		
		<script type="text/javascript">
		
			function checkBooking(){
				
				var tickLeft = document.bookingticketform.tickLeft;
				var notickets =document.getElementById("notickets");
				if (tickLeft.value == 0){
				
					alert('Booking Not Possible As No Tickets Left For The Show');
					return false;
				} else {
					
					if(notickets.value == '' || notickets==null){
						
						alert('Invalid No Of Tickets');
						return false;
					}
				}
				
				return true;
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
																height="124" />
														</a>
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
														<jsp:include page="CustomerOptions.jsp"></jsp:include>
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
																					<td valign="top" width="631" align="left"
																						background="images/green-box.jpg" height="274">


																						<br/><br/>
																						<center>
																						<font color="white" size="3">Booking Tickets For Movie																						</font>
																						</center>
																						<%
																						   String logintype=(String)session.getAttribute("logintype");
																						   Integer userid=(Integer)session.getAttribute("userid");
																						   int uid=userid.intValue();
																						   int mtid=Integer.parseInt(request.getParameter("mtid"));
																						   int ticketsLeft = new BookingDAO().getAvailSeatInfo(mtid);
																						 %>
																						 <form name="bookingticketform" action="./BookingTicketAction" onsubmit="return checkBooking();">
																						 <input type="hidden" name="logintype" value="<%=logintype %>" />
																						 <input type="hidden" name="userid" value="<%=uid %>" />
																						 <input type="hidden" name="mtid" value="<%=mtid %>" />
																						 <input type="hidden" name="tickLeft" value="<%=ticketsLeft %>" />
																						 <table align="center">
																						 <tr>
																						 <td colspan="2">No of Seats Available</td>
																						 <td><%=ticketsLeft %></td>
																						 
																						 </tr>
																						 <tr>
																						 <td>No of Tickets</td>
																						 <td><input type="text" name="notickets" /></td>
																						 <td><input type="submit" value="BookTicket" /></td>
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
									<td width="200" align="center" background="images/foot-bg.jpg">t

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