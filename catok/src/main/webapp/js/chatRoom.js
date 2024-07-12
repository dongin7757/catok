window.onload = function(){
	
	let listBody = document.getElementById('friendList');
//	console.log(listBody);
	let trList = [];
	trList = listBody.querySelectorAll('tr')
	
	trList.forEach(tr => {
		const friendId = tr.querySelector('.friendId').value;
		const roomType = tr.querySelector('.roomType').value;
		const chatId = tr.querySelector('.chatId').value
		console.log('friendId : ', friendId);
		console.log('roomType : ', roomType);
		console.log('chatId : ', chatId);
		tr.addEventListener('dblclick', function(){
			if(roomType == "1") {
				getOneChat(friendId);
			}
			if(roomType == "N") {
				getGroupChat(chatId);
			}
		});
	})
}


//1:1채팅일 경우 가져오기.
function getOneChat(friendId){
	console.log(friendId);
    console.log(roomType);
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


//1:n 채팅 가져오기
function getGroupChat(chatId){
	var form = document.createElement("form");
	form.setAttribute("method", "post");
	form.setAttribute("action", "groupChatPopup.do");
	form.setAttribute("target", "popupWindow");
	
	var input = document.createElement("input");
	input.setAttribute("type", "hidden");
	input.setAttribute("name", "chatId");
	input.setAttribute("value", chatId);
	
	form.appendChild(input);
	document.body.appendChild(form);
	
	window.open('', 'popupWindow', 'width=400,height=600');
	form.submit();
	document.body.removeChild(form);
}




function getMyFriList(){

	fetch('./getMyFriList.do', {
		method : "GET"
	})
	.then(response => {
		if (!response.ok) {
			throw new Error('Network response was not ok');
		}
		return response.json();
	})
	.then(data => {
		let tbody = document.querySelector('#friList');
		console.log(tbody);
		console.log(data);
		let html = '';
	
		data.forEach(friend => {
				html += `<tr> <td>${friend.friend_id}</td> <td><input type="checkbox" class="friendsCheckbox" onclick="friendsChk(this)" value = ${friend.friend_id}></td> </tr>`	
				console.log(friend.friend_id);
				console.log(html);
			}
		)
		tbody.innerHTML = html;
	})
	
}

function friendsChk() {
	let selectAllCheckbox = document.getElementById('selectAll');
    let friendsCheckbox = document.querySelectorAll('.friendsCheckbox');
	let checked = document.querySelectorAll('input[class="friendsCheckbox"]:checked');
	
	if(friendsCheckbox.length === checked.length) {
		selectAllCheckbox.checked = true;
	} else {
		selectAllCheckbox.checked = false;
	}
}

function allChk() {
	let selectAllCheckbox = document.getElementById('selectAll');
    let friendsCheckbox = document.querySelectorAll('.friendsCheckbox');
    selectAllCheckbox.addEventListener('change', function() {
        friendsCheckbox.forEach(checkbox => {
            checkbox.checked = selectAllCheckbox.checked;
        });
    });
}
	
function createGroupChat(){
	let chkedList = document.querySelectorAll('.friendsCheckbox:checked');
	console.log('##영태의 chked : ', chkedList);
	let friends = [];
	
	chkedList.forEach(data => {
		console.log(data);
		friends.push(data.value);
	})
	
	console.log(friends);
    
    let chat_title = document.getElementById("chat_title").value;
    
    console.log(chat_title);
    
    const bodydate = JSON.stringify({"friends" : friends, "chat_title" : chat_title});
    
    
//    let bodydate = JSON.stringify(friends);
    console.log(bodydate);
    
    
    
	fetch('./inviteFriendsToChatroom.do', {
		method : "POST",
		headers : {
			'Content-Type':'application/json'
		},
		body: bodydate
	})
	.then(response => {
		if (!response.ok) {
			alert('방 생성에 실패하였습니다!');
			throw new Error('Network response was not ok');
		}
		//console.log(response.text());
		return response.text();
	})
	.then(data => {
		
		alert('방이 생성되었습니다!');
		console.log(data);
		window.open(data, 'popupWindow', 'width=400,height=600');
		
	})
	
}