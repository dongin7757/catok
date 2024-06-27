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