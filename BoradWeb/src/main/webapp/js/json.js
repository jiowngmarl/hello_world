/**
 * json.js
 */

const jsonStr = `[{"id":1,"first_name":"Myrwyn","last_name":"Beech","email":"mbeech0@redcross.org","gender":"Male","salary":4139},
{"id":2,"first_name":"Malissa","last_name":"Gasperi","email":"mgasperi1@princeton.edu","gender":"Female","salary":6468},
{"id":3,"first_name":"Berny","last_name":"Erb","email":"berb2@123-reg.co.uk","gender":"Female","salary":4592},
{"id":4,"first_name":"Athene","last_name":"McGeever","email":"amcgeever3@hibu.com","gender":"Female","salary":6717},
{"id":5,"first_name":"Ashby","last_name":"Niven","email":"aniven4@rediff.com","gender":"Genderfluid","salary":2764},
{"id":6,"first_name":"Roxy","last_name":"Mobius","email":"rmobius5@weather.com","gender":"Female","salary":5065},
{"id":7,"first_name":"Giffard","last_name":"Toon","email":"gtoon6@yellowbook.com","gender":"Male","salary":7637},
{"id":8,"first_name":"Lynea","last_name":"Kissock","email":"lkissock7@bbb.org","gender":"Female","salary":9624},
{"id":9,"first_name":"Lurette","last_name":"Ronisch","email":"lronisch8@opera.com","gender":"Female","salary":3036},
{"id":10,"first_name":"Wylie","last_name":"Mungin","email":"wmungin9@technorati.com","gender":"Polygender","salary":4634},
{"id":11,"first_name":"Garland","last_name":"Bern","email":"gberna@bloomberg.com","gender":"Female","salary":6232},
{"id":12,"first_name":"Carey","last_name":"Beaston","email":"cbeastonb@cnn.com","gender":"Male","salary":7398},
{"id":13,"first_name":"Lauretta","last_name":"Spiby","email":"lspibyc@wikipedia.org","gender":"Female","salary":8533},
{"id":14,"first_name":"Todd","last_name":"Swancott","email":"tswancottd@moonfruit.com","gender":"Male","salary":9253},
{"id":15,"first_name":"Daphene","last_name":"Hughlock","email":"dhughlocke@army.mil","gender":"Female","salary":9075}]`;

let obj = JSON.parse(jsonStr); // json타입의 문자열을 object로 변경
let str = JSON.stringify(obj); // object를 json타입의 문자열로 변경
console.log(obj);

// 한건 데이터를 매개값으로 tr을 생성하는 함수
function makeRow(emp = {id, first_name, last_name, email, gender, salary}) {
	const fields = ['id', 'first_name', 'last_name', 'email'];
	let tr = document.createElement('tr'); // <tr></tr> 태그를 만들기 위해서 선언하는것
	for (let i=0; i<fields.length; i++) {
		let td = document.createElement('td'); // <td></td< 태그를 만들어줌
		td.innerHTML = emp[fields[i]]; // <td>emp의 1번째(id)부터 fields.length까지 넣어준다</td>
		tr.appendChild(td);
	}
	return tr;
}

obj.forEach(function(item, idx, ary) {
	let tr = makeRow(item);
	document.querySelector('tbody#target').appendChild(tr);
})
