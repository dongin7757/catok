/*let formData = new URLSearchParams();
formData.append('user_id', user_id);
formData.append('user_name', user_name);*/

function search() {
	const user_id = document.getElementById('searchUserId').value;
	const user_name = document.getElementById('searchUserName').value;

	document.querySelector('.friendsList').innerHTML = '';

	fetch('./searchFriendsInfo.do', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json', // 요청 헤더에 JSON 타입을 명시
		},
		body: JSON.stringify({ 'user_id': user_id, 'user_name': user_name }), // 본문에 JSON 형식의 데이터 포함
	})
		.then(response => {
			if (!response.ok) {
				throw new Error('Network response was not ok');
			}
			return response.json(); // JSON 형식으로 데이터 파싱
		})
		.then(data => {
			console.log('Received data:', data);
			var html = '';
			var td = document.querySelector('.friendsList');

			data.forEach(item => {
				html += ' <tr>';
				html += '  <td class="friendsList">' + item.user_id + '</td>';
				html += '  <td>' + item.user_name + '</td>';
				html += '  <td><button type="button" value='+ item.user_id +'>추가</button></td>';
				html += ' </tr>';
			});

			td.innerHTML += html; // HTML을 friendsList 클래스를 가진 요소에 추가

			var totalCount = td.querySelectorAll('tr').length;
			console.log('Total count:', totalCount);

			return data;
		})
		.then(data => {
			console.log(data);
		})
		.catch(error => {
			console.error('에러발생:', error);
		});

	console.log(user_id);
	console.log(user_name);
}

function addFriend(event) {
    const friend_id = event.target.value;
    console.log('friend_id:', friend_id);
    
    fetch('./addFriend.do', {
        method: 'POST', 
        headers: {
            'Content-Type': 'application/json' 
        },
        body: JSON.stringify({'friend_id': friend_id}) 
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok ' + response.statusText);
        }
        return response.json();
    })
    .then(data => {
        console.log('Success:', data);
        alert('친구추가가 완료되었어용');
        window.location.reload();
    })
    .catch(error => {
        console.error('Error:', error);
    });
};
