<%@page import="com.iei.cal.model.vo.Cal"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.chk-btn-div{
		width: 300px;
		text-align: center;
		margin: 0 auto;
		margin-bottom: 20px;
	}
	.chk-btn{
		width: 200px;
		height: 50px;
	}
	.header-div{
		width: 1200px;
		margin: 0 auto;
		margin-top: 50px;
		padding-bottom: 30px;
		border-bottom: 1px solid #a8a8a8;
	}
</style>
<link href='/fullcalendar/main.css' rel='stylesheet' />
    <script src='/fullcalendar/main.js'></script>
    <script>
    	document.addEventListener('DOMContentLoaded', function() {
        	        });

    </script>
</head>
<body>
    <%@include file="/WEB-INF/views/common/header.jsp" %>
    <div class="header-div">
    	<h1>출석체크</h1>
    </div>
    
    <div class="page-content">
		<div id='calendar'></div>
    </div>
    <div class="chk-btn-div">
    	<input type="hidden" name="userId" class="userId" value="<%=loginUser.getUserId() %>">
    	<input type="hidden" name="userPoint" class="userPoint" value="<%=loginUser.getUserPoint() %>">
    	<input type="hidden" name="userNo" class="userNo" value="<%=loginUser.getUserNo() %>">
    	<button class="chk-btn bc6" id="chk-btn">출석체크</button>
    	
    	
    </div>
    
   
    
    
    <script>
    	$("#chk-btn").on("click",function(){
    		const userId = $(".userId").val();
    		const userPoint = $(".userPoint").val();
    		const today = $(".fc-day-today");
    		const userNo = $(".userNo").val();
    		
    		today.empty();
    		$.ajax({
    			url : "/calEvent.do",
    			type : "post",
    			data : {userId : userId, userPoint : userPoint, userNo : userNo},
    			dataType : "Json",
    			success : function(data) {
					if(data == -1){
						location.href = "/calNoView.do";
					}else{
						location.href = "/calView.do";
					}
				},
    			error : function() {
					console.log("에러");
				}
    		})
    	});
    	$(function(){
    		const userNo = $(".userNo").val();
    		const today = $(".fc-day-today");
    		$.ajax({
    			url : "selectCalCheck.do",
    			type : "post",
    			data : {userNo : userNo},
    			dataType : "Json",
    			success : function(data){
    				console.log(data);
    				
    				
    				var calendarEl = document.getElementById('calendar');
    	            var calendar = new FullCalendar.Calendar(calendarEl, {
    	                // Tool Bar 목록 document : https://fullcalendar.io/docs/toolbar
    	                headerToolbar: {
    	                    left: 'prevYear,prev,next,nextYear',
    	                    center: 'title',
    	                    right: 'dayGridMonth'
    	                },

    	                selectable: true,
    	                selectMirror: true,

    	                navLinks: true, // can click day/week names to navigate views
    	                editable: true,
    	                // Create new event
    	                select: function (arg) {
    	                    Swal.fire({
    	                        html: "<div class='mb-7'>Create new event?</div><div class='fw-bold mb-5'>Event Name:</div><input type='text' class='form-control' name='event_name' />",
    	                        icon: "info",
    	                        showCancelButton: true,
    	                        buttonsStyling: false,
    	                        confirmButtonText: "Yes, create it!",
    	                        cancelButtonText: "No, return",
    	                        customClass: {
    	                            confirmButton: "btn btn-primary",
    	                            cancelButton: "btn btn-active-light"
    	                        }
    	                    }).then(function (result) {
    	                        if (result.value) {
    	                            var title = document.querySelector("input[name=;event_name']").value;
    	                            if (title) {
    	                                calendar.addEvent({
    	                                    title: title,
    	                                    start: arg.start,
    	                                    end: arg.end,
    	                                    allDay: arg.allDay
    	                                })
    	                            }
    	                            calendar.unselect()
    	                        } else if (result.dismiss === "cancel") {
    	                            Swal.fire({
    	                                text: "Event creation was declined!.",
    	                                icon: "error",
    	                                buttonsStyling: false,
    	                                confirmButtonText: "Ok, got it!",
    	                                customClass: {
    	                                    confirmButton: "btn btn-primary",
    	                                }
    	                            });
    	                        }
    	                    });
    	                },

    	                // Delete event
    	                eventClick: function (arg) {
    	                    Swal.fire({
    	                        text: "Are you sure you want to delete this event?",
    	                        icon: "warning",
    	                        showCancelButton: true,
    	                        buttonsStyling: false,
    	                        confirmButtonText: "Yes, delete it!",
    	                        cancelButtonText: "No, return",
    	                        customClass: {
    	                            confirmButton: "btn btn-primary",
    	                            cancelButton: "btn btn-active-light"
    	                        }
    	                    }).then(function (result) {
    	                        if (result.value) {
    	                            arg.event.remove()
    	                        } else if (result.dismiss === "cancel") {
    	                            Swal.fire({
    	                                text: "Event was not deleted!.",
    	                                icon: "error",
    	                                buttonsStyling: false,
    	                                confirmButtonText: "Ok, got it!",
    	                                customClass: {
    	                                    confirmButton: "btn btn-primary",
    	                                }
    	                            });
    	                        }
    	                    });
    	                },
    	                dayMaxEvents: true, // allow "more" link when too many events
    	                // 이벤트 객체 필드 document : https://fullcalendar.io/docs/event-object
    	                events: data
    	                
    	            });

    	            calendar.render();

    				
    				
    				
    				
    				
    				
    				
    				
    			},
    			error : function() {
    				
				}
    		});
    	});
    </script>
    
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>