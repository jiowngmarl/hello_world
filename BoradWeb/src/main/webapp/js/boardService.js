/**
 * boardService.js
 */

const svc = {
	name: "홍길동",
	replyList: function(bno, successCallback, errorCall) {
		fetch('replyList.do?bno='+bno)
		.then(result => result.json())
		.then(successCallback)
		.catch(errorCall)
	},
	
	removeReply(rno, successCallback, errorCall) {
		fetch('removeReply.do?rno=' + rno)
		.then(result => result.json())
		.then(successCallback)
		.catch(errorCall)
	},
	
	addReply(rvo={bno, reply, replyer}, successCallback, errorCall) {
			fetch('addReply.do?bno=' + rvo.bno + '&reply=' + rvo.reply + '&replyer=' + rvo.replyer)
			.then(result => result.json())
			.then(successCallback)
			.catch(errorCall)
	},
}