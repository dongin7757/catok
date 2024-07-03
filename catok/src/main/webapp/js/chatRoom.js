window.onload = function(){
	
	let listBody = document.getElementById('friendList');
	
//	console.log(listBody);
	
	let trList = []; 
	trList = listBody.querySelectorAll('tr')
	
	trList.forEach(tr => {
		const friendId = tr.querySelector('input').value
//		console.log(friendId);
		tr.addEventListener('dblclick', function(){
			createNewChat(friendId);
		});
	})
	

	
}


function createNewChat(friendId){
	console.log(friendId);
    
    var form = document.createElement("form");
    form.setAttribute("method", "post");
    form.setAttribute("action", "chatPopup.do");
    form.setAttribute("target", "popupWindow");

    var input = document.createElement("input");
    input.setAttribute("type", "hidden");
    input.setAttribute("name", "chatPopup");
    input.setAttribute("value", friendId); // 전송할 데이터 설정

    form.appendChild(input);
    document.body.appendChild(form);

    window.open('', 'popupWindow', 'width=400,height=600');
    form.submit();
    document.body.removeChild(form);

}


function getMyFriList(){

	fetch('./getMyFriList.do', {
		headers : {
			    'Content-Type': 'text/plain', // 일반 텍스트로 설정
			},
		method : "GET"
	})
	.then(response => {
		if (!response.ok) {
			throw new Error('Network response was not ok');
		}
		return response.json();
	})
	.then(data => {
		
		const TBODY = document.querySelector('#friList');
		
		let html = '';
	
		data.forEach(friend => {
					html += `<tr> <td>${data.friend_id}</td> <td><input type="checkbox" value = ${data.friend_id}></td> </tr>`	
			}
		)		
		
		TBODY.appendChild = html;
			
	})
	
}


function createGroupChat(){
	
	
}