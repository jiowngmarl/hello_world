/**
 * board2.js
 */


const table = new DataTable ('#example', {
    ajax: 'replyListDatatable.do?bno='+bno,
    columns: [
        { data: 'REPLY_NO' },
        { data: 'REPLY' },
        { data: 'REPLYER' },
        { data: 'REPLY_DATE' }
    ],
	lengthMenu: [
	    [5 ,10, 25, 50, -1],
	    [5, 10, 25, 50, 'All']
	],
	order: [[0, 'desc']]
});

function addNewRow() {
	// control을 통해서 db에 한건 생성
	fetch('addReply.do?bno='+ bno + '&replyer=' + replyer + '&reply=' + 'test')
	.then(result => result.json())
	.then(result => {
		console.log(result);
		let obj = result.retVal;
		
		table.row
		    .add({
		        REPLY_NO: obj.replyNo,
		        REPLY: obj.reply,
		        REPLYER: obj.replyer,
		        REPLY_DATE:obj.replyDate
			})
			.draw(false);
	})
	.catch(err => console.error(err));
	

        
}
 
document.querySelector('#addRow').addEventListener('click', addNewRow);

// 삭제기능

// document.querySelector('tr.selected').children[0].innerHTML  ->  선택된 selected의 하위 tr요소의 innerHTML을 가져와서 fetch에 적용시켜야 실제 db에서도 삭제가 적용됨, (미완성)
let rno;
table.on('click', 'tbody tr', (e) => { // tbody 하위의 tr에만 click이벤트가 발생하면 (e)를 실행한다

	console.log(e.currentTarget.children[0].innerHTML); 
    let classList = e.currentTarget.classList; // class목록을 배열형태로 가지고 있음
	
	
	//classList에 contains 메소드를 사용하여 있으면 true, 없으면 false를 반환, 추가할때는 add, 제거할때는 remove를 사용
    if (classList.contains('selected')) {
        classList.remove('selected');
    }
    else {
        table.rows('.selected').nodes().each((row) => row.classList.remove('selected')); // 이전에 선택된것이 있으면 제거하고 새로 선택한것을 target한다
        classList.add('selected');
    }
	
	rno = e.currentTarget.children[0].innerHTML
});

 
document.querySelector('#delRow').addEventListener('click', function () {
	fetch('removeReply.do?rno=' + rno)
	.then(result => {
		table.row('.selected').remove().draw(false);
	})
	.catch(err => console.error(err));
     // button의 click 이벤트가 발생하면 실제로 화면에서 삭제
});

//end of file