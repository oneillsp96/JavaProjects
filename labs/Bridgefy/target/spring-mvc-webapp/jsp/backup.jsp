<div class="row">
                <div class="col-xs-6">
                    <c:forEach var="student" items="${studentList}">
                    <table class="table">
                       
                    
                              <tbody>
                                   
                            <tr>
                                <th>
                                    First Name: 
                                </th>
                                <td>
                                    ${student.firstName}
                                </td>
                            </tr>
                            <tr>
                                <th>
                                    Last Name:  
                                </th>
                                <td>
                                    ${student.lastName}
                                </td>
                            </tr>
                            <tr>
                                <th>
                                    Points:
                                </th>
                                <td>
                                    ${student.points}
                                </td>
                            </tr>                    
                            <tr>
                                <th>
                                    Side:
                                </th>
                                <td>
                                    ${student.side}
                                </td>
                            </tr> 



                            <tr>
                                <td align="right"><a href="deleteStudent?studentId=${student.studentId}"><button type="submit" class="btn-lg btn-info">Delete</button></a></td>                                
                                <td><a href="displayEditStudentForm?studentId=${student.studentId}"><button type="submit" class="btn-lg btn-info">Edit</button></a></td>
                        <br />
                        <br />
                        </tr>
                                  
                        </tbody>
                    </table>

                </c:forEach>
                    
                    
                    
                    
                    <div class="row">
                        <div class="col-xs-6">

                        </div>
                    </div>
                </div>
            </div>