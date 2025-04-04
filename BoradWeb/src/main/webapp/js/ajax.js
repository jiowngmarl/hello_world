/**
 * ajax.js
 * 
 * json.js에서는 데이터를 직접 변수에 넣고 출력했다면 여기서는 데이터가 존재하는 주소에 접근하여 출력
 */

let dataAry;

const xhtp = new XMLHttpRequest();
xhtp.open('get', 'data/MOCK_DATA.json'); //데이터를 가지고있는 페이지의 경로를 요청
xhtp.send();
xhtp.onload = function() { // load이벤트가 발생하면 {}안의 내용이 실행
	let obj = JSON.parse(xhtp.responseText);
	console.log(obj);
	dataAry = obj;
	
	// 화면에 출력
	obj.forEach(function(item, idx, ary) {
		let tr = makeRow(item);
		document.querySelector('tbody#target').appendChild(tr);
	})
}

// 한건 데이터를 매개값으로 tr을 생성하는 함수
function makeRow(emp = {id, first_name, last_name, email, gender, salary}) {
	const fields = ['id', 'first_name', 'last_name', 'gender'];
	let tr = document.createElement('tr'); // <tr></tr> 태그를 만들기 위해서 선언하는것
	
	// checkbox 생성
	let tdd = document.createElement('td');
	let chk = document.createElement('input');
	chk.setAttribute('type', 'checkbox');
	tdd.appendChild(chk);
	tr.appendChild(tdd);
	
	
	for (let i=0; i<fields.length; i++) {
		let td = document.createElement('td'); // <td></td< 태그를 만들어줌
		td.innerHTML = emp[fields[i]]; // <td>emp의 1번째(id)부터 fields.length까지 넣어준다</td>
		tr.appendChild(td);
	}
	// 삭제버튼을 생성하기위한 td생성
	
	let btn = document.createElement('button');
	let td = document.createElement('td');
	btn.setAttribute('class','btn btn-danger');
	btn.innerText = '삭제';
	btn.addEventListener('click', deleteRow)
	// 부모, 자식 관계를 형성
	td.appendChild(btn);
	tr.appendChild(td);
		
	return tr;
}

// btn의 이벤트핸들러 함수 선언
function deleteRow(e) {
	console.log(e.target);
	e.target.parentElement.parentElement.remove();
}

document.querySelector('thead input[type="checkbox"]').addEventListener('change', function(e) {
	
	// tbody영역의 checkbox의 값을 변경
	let checked = e.target.checked;
	document.querySelectorAll('tbody input[type="checkbox"]').forEach(function(item) {
		item.checked = checked;
	})
})

document.querySelector('select#searchGender').addEventListener('change', function(e) {
	
	console.log(e.target.value);
	let genderValue = e.target.value;
	//dataAry의 배열을 활용해서 출력
	//dataAry의 gender속성을 비교해서 출력하기 (출력하기전에 목록을 초기화)
	document.querySelector('tbody#target').innerHTML = "";
	dataAry.forEach(function(item){
		// 비교문을 활용하여 같은 값만 출력
		if(genderValue == 'all' || item.gender == genderValue) {
			let tr = makeRow(item);
			document.querySelector('tbody#target').appendChild(tr); // appendChild는 계속 누적하기때문에 위에서 초기화를 시킨다
		}
	});

}) 