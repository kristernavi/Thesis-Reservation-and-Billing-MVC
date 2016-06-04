<%@ include file="/WEB-INF/jsp/includes.jsp"%>


                        <div class="table-responsive">
					 
                            <table class="table table-default" border="0">
                                	<thead>
							<tr>
								<th width="4%">#</th>
								<th width="12%">Description</th>
								<th width="12%">Rate</th>
								
								<th width="12%"></th>
							</tr>
						</thead>
								<br /><br />
								
                                <tbody align="center">
                                   	<c:forEach items="${addOnList}" var="addOn" varStatus="loopCounter">
								<tr>
									<td>${loopCounter.count}</td>
									<td>${addOn.description}</td>
									<td>${addOn.rate}</td>
									
									
									<td>
									<nobr>
									<form:form commandName="addOnDetail" method="POST" action="${pageContext.request.contextPath}/auth/billing/saveAddon">
								
																	
																	<form:hidden path="AddOn.id" value="${addOn.id }"/>
																	<form:hidden path="occupancy.id" value="${occ_id }"/>
																	<button class="btn btn-success	"
												type="submit">

												<i class="fa fa-pencil"></i> Avail
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
