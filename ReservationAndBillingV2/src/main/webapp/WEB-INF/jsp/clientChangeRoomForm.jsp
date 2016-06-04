<%@ include file="/WEB-INF/jsp/includes.jsp"%>


                        <div class="table-responsive">
					 
                            <table class="table table-default" border="0">
                                <thead align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                </thead>
								<br /><br />
								
                                <tbody align="center">
                                   	<c:forEach items="${changeRoom}" var="room" varStatus="loopCounter">
								<tr>
									<td>${room.roomWithPrefix2 }</td>
									<td>${room.type }</td>
									<td>${room.capacity }</td>
									
									
									<td>
									<nobr>
									<form:form commandName="cr" method="POST" action="${pageContext.request.contextPath}/saveChangeRoom">
									<form:input path="room_id" value="${room.id }" type="hidden"/>
									<form:input path="rr_id" type="hidden"/>
									<form:input path="key" type="hidden"/>
									<button class="btn btn-success	"
												type="submit">

												<i class="fa fa-pencil"></i> Change
											</button>
											</form:form>
									</nobr>
									
									
									</td>
								</tr>
								
							</c:forEach>

                                </tbody>
                            </table>
                        </div>
						<br />
