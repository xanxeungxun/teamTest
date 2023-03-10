/*
1. 아이디 : 5~25자 영어소문자,숫자 입력 / 비빈과 달라야함
2-1. 비번 : 8~25자 영어대소문자,숫자 입력 / 아이디와 달라야함
2-2. 비번 확인 : 비밀번호와 값 같은지 확인
3. 닉네임 : 영어대소문자, 한글 최소 1글자 이상 ... 10글자 이내
4. 이름 : 한글 최소 1글자 이상 ... 15글자 이내
5. 전화번호 : 010... - 제외
6. 이메일주소 : 5~25자 영어대소문자/숫자 입력
*/
/*
function trueBox(i) {
    $(".reg-msg").eq(i).removeAttr("color","#f86697");
    $(".input-form").eq(i).removeAttr("outline","2px solid #f86697");

    $(".reg-msg").eq(i).removeClass("active-reg-msg");
    $(".input-form").eq(i).removeClass("active-reg-input");
}
*/

const result = [false,false,false,false,false,false]; //처음엔 기본적으로 false

//true일 때 CSS
function trueDesign(i){
    $(".check-circle").eq(i).addClass("active-check-circle");
    $(".reg-msg").eq(i).text("");
    $(".reg-msg").eq(i).removeClass("active-reg-msg");
    $(".input-form").eq(i).removeClass("active-reg-input");
}
//false일 때 CSS
function falseDesign(i){
    $(".check-circle").eq(i).removeClass("active-check-circle");
    $(".reg-msg").eq(i).addClass("active-reg-msg");
    $(".input-form").eq(i).addClass("active-reg-input");
}


//1. 아이디
$("[name=userId]").on("change",function(){

});

//1-2. 아이디, 비번 같으면 안됨
function idDifferPw(i){
    $(".reg-msg").eq(i).text("아이디와 같은 비밀번호는 사용할 수 없습니다.");
    falseDesign(i);
}

//1-3. 아이디 중복 체크
$("#userId").on("change",function(){
	const userId = $(this).val();
	//아이디 정규표현식 검사
	const idReg = /^[a-z0-9]{5,25}$/;
    const check = idReg.test(userId);

    if($("[name=userId]").val() == $("[name=userPw]").val()) {
        idDifferPw(0);
        return;
    } else {
        if(check) {
            //true

            
            //정규식 통과되면 아이디 중복체크
            $.ajax({
				url : "/checkId.do",
				type : "get",
				data : {userId:userId},
				success : function(data){
					if(data == "1"){
						$(".reg-msg").eq(0).text("중복된 아이디가 있습니다.");
						falseDesign(0);
            			result[0] = false;
            			
					} else if(data == "0"){
						trueDesign(0);
            			result[0] = true;
					}
				}
			});
    
        } else {
            //false
            $(".reg-msg").eq(0).text("5~25자의 영문 소문자/숫자로만 입력해주세요.");
            falseDesign(0);
            result[0] = false;
        }
    }
	
});

//2-1. 비밀번호
$("[name=userPw]").on("change",function(){
    const pwReg = /^[a-zA-Z0-9]{8,25}$/;
    const check = pwReg.test($(this).val());

    if($("[name=userId]").val() == $("[name=userPw]").val()) {
        idDifferPw(1);
        return;
    } else {
        if(check) {
            //true
            trueDesign(1);
            result[1] = true;
    
        } else {
            //false
            $(".reg-msg").eq(1).text("8~25자의 영문 대소문자/숫자로만 입력해주세요.");
            falseDesign(1);
            result[1] = false;
        }
    }
});


//2-2. 비밀번호 확인
$("[name=userPwCh]").on("change",function(){
    const pwValue = $("[name=userPw]").val();
    const pwReValue = $(this).val();
    if(pwValue == pwReValue) {
        trueDesign(2);
        result[2] = true;

    } else{
        $(".reg-msg").eq(2).text("비밀번호가 일치하지 않습니다.");
        falseDesign(2);
        result[2] = false;

    }
});


//3. 닉네임
$("[name=userNick]").on("change",function(){
    const nickReg = /^[a-zA-Z가-힣]{1,10}$/;
    const check = nickReg.test($(this).val());

    if(check) {
        //true
        trueDesign(3);
        result[3] = true;

    } else {
        //false
        $(".reg-msg").eq(3).text("10글자 이내로 영문 대소문자/한글로만 입력해주세요.");
        falseDesign(3);
        result[3] = false;
    }
});


//4. 이름
$("[name=userName]").on("change",function(){
    const nameReg = /^[가-힣]{1,15}$/;
    const check = nameReg.test($(this).val());

    if(check) {
        //true
        trueDesign(4);
        result[4] = true;

    } else {
        //false
        $(".reg-msg").eq(4).text("15글자 이내로 한글로만 입력해주세요.");
        falseDesign(4);
        result[4] = false;
    }
});


//5. 전화번호
$("[name=userPhone]").on("change",function(){
    const phoneReg = /^010-[0-9]{3,4}-[0-9]{4}$/;
    const check = phoneReg.test($(this).val());

    if(check) {
        //true
        trueDesign(5);
        result[5] = true;

    } else {
        //false
        $(".reg-msg").eq(5).text("전화번호를 올바르게 입력했는지 확인해주세요.");
        falseDesign(5);
        result[5] = false;
    }
});


//6. 이메일주소
$("[name=userEmail]").on("change",function(){
    const emailReg = /^[a-zA-Z0-9]{5,25}@/;
    const check = emailReg.test($(this).val());

    if(check) {
        //true
        trueDesign(6);
        result[6] = true;

    } else {
        //false
        $(".reg-msg").eq(6).text("5~25자의 영문 대소문자/숫자로만 입력해주세요.");
        falseDesign(6);
        result[6] = false;
    }
});

//6-2. 이메일 인증
let mailCode;

$("#emailCheck").on("click",function(){
	const userEmail = $("#userEmail").val();
	$.ajax({
		url : "/emailCheck.do",
		data : {userEmail : userEmail},
		type : "post",
		success : function(data) {
			console.log(data); //... 배포하기 전엔 console.log() 숨겨야함
			if(data == "null") {
				alert("이메일 주소를 확인해주세요.");
			} else {
				mailCode = data; //정상적으로 데이터를 보내면 data를 mailCode에 대입
				$("#auth").slideDown();
				authTime();
			}
		},
		error : function() {
			console.log("에러 발생");
		}
	});
});

let intervalId;
function authTime(){
	$("#timeZone").html("<span id='min'>3</span> : <span id='sec'>00</span>");
	intervalId = window.setInterval(function(){
		timeCount();
	},1000); //1초마다
}

function timeCount(){
	const min = $("#min").text();
	const sec = $("#sec").text();
	if(sec == "00") {
		if(min != "0"){
			const newMin = Number(min) - 1;
			$("#min").text(newMin);
			$("#sec").text(59);
		} else {
			//끝난 시점
			window.clearInterval(intervalId);
			mailCode = null;
			
			//시간 만료되면 메세지 뜸
			$("#authMsg").text("인증시간 만료");
			$("#authcMsg").css("color","#f86697");
		}
		
	} else {
		const newSec = Number(sec) - 1;
		if(newSec < 10) {
			$("#sec").text("0"+newSec); //09, 08, 07 ...
		} else {
			$("#sec").text(newSec);
		}
	}
}

$("#authBtn").on("click",function(){
	if(mailCode == null) {
		$("#authMsg").text("인증시간 만료");
		$("#authMsg").css("color","red");
		
	} else {
		const authCode = $("#authCode").val();
		if(authCode == mailCode){
			$("#authCode").prop("readonly",true);
			$("#authMsg").text("인증 완료");
			$("#authMsg").css("color","#e98ead");
			
			window.clearInterval(intervalId);//인증 완료되면 시간도 멈춤
			
		} else {
			$("#authMsg").text("인증 실패");
			$("#authMsg").css("color","#f86697");
		}
	}
	
});

//값들을 모두 입력해야함
$("[type=submit]").on("click",function(event){
    if( !(result[0] && result[1] && result [2] && result [3] && result [4] && result [5]) ) {
        event.preventDefault(); 
        //해당 이벤트의 기본이벤트를 제거 (ex. submit 버튼의 form 제출 이벤트)
    } 
});

/*약관 동의*/
//전체 체크
$("#allAgreement").on("change",function(){
    if($(this).prop("checked")) {
        $("[name='agreement']").prop("checked", true);
    } else {
        $("[name='agreement']").prop("checked", false);
    }
});