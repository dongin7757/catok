/*let formData = new URLSearchParams();
formData.append('user_id', user_id);
formData.append('user_name', user_name);*/

function search() {
	let user_id = document.getElementById('searchUserId').value;
	let user_name = document.getElementById('searchUserName').value;

	document.querySelector('.friendsList').innerHTML = '';

	fetch('./searchFriendsInfo.do', {
		method: 'POST', // 또는 'PUT'
		headers: {
			'Content-Type': 'application/json', // 요청 헤더에 JSON 타입을 명시
			//'Content-Type': 'application/x-www-form-urlencoded', // URL 인코딩 형식으로 설정
		},
		body: JSON.stringify({ 'user_id': user_id, 'user_name': user_name }), // 본문에 JSON 형식의 데이터 포함
		//body: formData.toString(), 
	})
		.then(response => {
			if (!response.ok) {
				throw new Error('Network response was not ok');
			}
			return response.json(); // JSON 형식으로 데이터 파싱
		})
		.then(data => {
			console.log('Received data:', data); // 받은 데이터를 콘솔에 출력

			var html = '';
			var td = document.querySelector('.friendsList');

			// data가 배열이라고 가정하고 forEach를 사용하여 각 요소에 접근
			data.forEach(item => {
				html += ' <tr>';
				html += '  <td class="friendsList">' + item.user_id + '</td>'; // user_id 값 사용
				html += '  <td>' + item.user_name + '</td>'; // user_name 값 사용
				html += '  <td><button type="button" value='+ item.user_id +'>추가</button></td>';
				html += ' </tr>';
			});

			td.innerHTML += html; // HTML을 friendsList 클래스를 가진 요소에 추가

			var totalCount = td.querySelectorAll('tr').length;
			console.log('Total count:', totalCount); // 추가된 요소의 총 개수를 콘솔에 출력

			return data; // 다음 Promise 체인에 데이터 전달
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

