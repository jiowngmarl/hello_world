/**
 * array.js
 */

const ary = [];
// 추가기능 push(마지막에 추가), unshift (앞에추가)
// 제거기능 pop, shift
// splice 추가, 수정, 삭제
// forEach()
ary.push('홍길동'); //마지막 위치
ary.push('김길동');
ary.unshift('최길동');

//ary.pop();
//ary.shift();

//ary.splice(0, 1); // 첫번째, 크기, 대체값 -> 대채값이 없으면 삭제를 킨다

// forEach메서드는 매개값을 함수를 갖는다


ary.forEach(function(item, idx, ary) {
	console.log(`item=> ${item}, index=> ${idx}, array=> ${ary}`);
});

// 함수
function addElement(elem = "noElem") {
	
	ary.push(elem);
	
}

// 화면에서 제거하는 요소
function deleteElement(e) {
	//alert('삭제버튼클릭됨');
	console.log(e.target.parentElement);
	e.target.parentElement.remove();
}


// 추가버튼에 클릭이벤트 추가

document.querySelector('button#addBtn').addEventListener('click', function() {
	
	
	let val = document.querySelector('input#userInput').value;
	addElement(val); // ary배열에 추가	
	//화면에 출력
	let html = '';
	ary.forEach(function(item, idx, ary){
		
		html += '<li>' + item + '<button onclick="deleteElement(event)">삭제</button></li>';
	});
	
	// ul태그 영억
	document.querySelector('ul#list').innerHTML = html;
});