/**
 * board1.js
 * XMLHttpRequest, fetch => 실행순서
 */

// 함수선언식
let successCallback = function successCallback(result){
		console.log(result);
		result.forEach(item => {
			makeRow2(item);
	});
}
		
function errorCallback(err){
		console.log(err);
}

function deleteFnc(rno = 21) {
	let deleteOK = confirm("삭제하시겠습니까?");
	if(!deleteOK) {
		return;
	}
	svc.removeReply(rno 
		,function(result){
			console.log(result);
			if(result.retCode == 'OK') {
				// id 속성으로 찾기
				document.querySelector('#rno_' + rno).remove();
				alert('삭제완료');
			}
		}
		,errorCallback);
}

// 이벤트
document.querySelector('button.addReply').addEventListener('click', function(e) {
	// 등록
	if(replyer == '') {
		alert('로그인하세요');
		return;
	}
	// bno, replyer, reply: #reply.value속성
	let reply = document.querySelector('#reply').value;
	if(reply == '') {
		alert('댓글을 등록하세요');
		return;
	}
	console.log(bno, reply, replyer);
	svc.addReply({bno, reply, replyer}//등록의 첫번째 param
		, function(result) {
			if (result.retCode == 'OK') {
				alert('등록성공');
				let item = result.retVal;
				makeRow2(item);
			} else {
				alert('등록실패');
			}
		}, errorCallback);
})

//목록 보여주기
svc.replyList(bno, successCallback, errorCallback);

	// 댓글정보를 이용하여 화면에 출력하는것
function makeRow2(item) {
	let html = `<li data-rno="${item.replyNo}" id="rno_${item.replyNo}">
		<span class="col-sm-2">${item.replyNo}</span>
		<span class="col-sm-5">${item.reply}</span>
		<span class="col-sm-2">${item.replyer}</span>
		<span class="col-sm-2"><button onclick="deleteFnc(${item.replyNo})">삭제</button></span>
	</li>`;
	let templ =  document.querySelector('div.content>ul');
	templ.insertAdjacentHTML('beforeend',html);
}
	
// 동기, 비동기(Asynchronous Javascript And Xml)
setTimeout(function(){	
	console.log('1');
	
	setTimeout(function(){	
		console.log('2');
		
		setTimeout(function(){	
			console.log('3');
		}, 1000);
	}, 1000);
}, 1000);