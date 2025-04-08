/**
 * board1.js
 * XMLHttpRequest, fetch => 실행순서
 */

let page = 1;


// 함수선언식
let successCallback = function successCallback(result){

		// 기존 댓글 목록을 화면에서 지우기
		document.querySelectorAll('div.reply div.content ul>li').forEach(function(item, idx) {
			if(idx) { // 자바스크립트에서는 falsy는(0, null, '', undeifned) 이 들어오면 false로 정의함
				item.remove();
			}
		});
		// 새로운 목록 출력
		result.forEach(item => {
			makeRow2(item);
	});
}
		
function errorCallback(err){
		console.log(err);
}

// 페이징 콜백
function pagingCallback(result) {
	
	//페이지목록 지우기
	document.querySelector('nav>ul.pagination').innerHTML = '';
	
	let totalCnt = result.totalCnt;
	
	// 첫페이지, 마지막페이지를 가져와야함 => 현재페이지를 기준을 계산
	let startPage, endPage;
	let prev, next;
	endPage = Math.ceil(page / 10) * 10;
	startPage = endPage - 9;
	let realEnd = Math.ceil(totalCnt / 5);
	endPage = endPage > realEnd ? realEnd : endPage;
	prev = startPage == 1 ? false : true;
	next = endPage < realEnd ? true : false;
	
	let prevContent;
	if(!prev) {
		prevContent = `<li class="page-item disabled">
		  <span class="page-link">Previous</span>
		</li>`
	} else {
		prevContent = `<li class="page-item">
		  <span class="page-link" data-page="${startPage - 1}">Previous</span>
		</li>`;
	}
	let prevTarget = document.querySelector(`nav>ul.pagination`);
	prevTarget.insertAdjacentHTML('beforeend', prevContent);
	
	
	for(let p=startPage; p<=endPage; p++) {
		let html = `<li class="page-item"><a class="page-link" href="#" data-page="${p}">${p}</a></li>`
		let target = document.querySelector('nav>ul.pagination')
		target.insertAdjacentHTML('beforeend', html);
	}
	// 이후페이지

	
	let nextContent;
	if(!next) {
		nextContent = `<li class="page-item disabled">
		  <a class="page-link" href="#">Next</a>
		</li>`;
	} else {
		nextContent = `<li class="page-item">
		  <a class="page-link" data-page="${endPage + 1}" href="#">Next</a>
		</li>`;
	}
	let nextTarget = document.querySelector(`nav>ul.pagination`);
	nextTarget.insertAdjacentHTML('beforeend', nextContent);
	
	// 링크이벤트 등록
	pageLink();
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

// 댓글페이지 링크 이벤트 등록
function pageLink() {
	document.querySelectorAll('nav>ul.pagination a').forEach(function(atag) {
		atag.addEventListener('click', function(e) {
			e.preventDefault(); // 이벤트의 기본기능을 차단하는 기능
			page = atag.dataset.page; // <a>3</a>
			// 댓글 목록
			svc.replyList({bno, page}, successCallback, errorCallback);
			// 페이징 목록
			svc.pagingList(bno, pagingCallback, errorCallback);
		})
	});
}

//목록 보여주기
// {bno : bno, page : page} 처럼 속성의 이름이 같을 경우 밑에처럼 줄여서 입력이 가능하다
svc.replyList({bno, page}, successCallback, errorCallback);

// 페이징목록 보여주기
svc.pagingList(bno, pagingCallback, errorCallback);

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