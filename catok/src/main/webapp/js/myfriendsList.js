function deleteFriend(event) {
    const friend_id = event.target.value;
    console.log('friend_id:', friend_id);
    
    fetch('./deleteFriend.do', {
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
        alert('친구가 삭제되었어용');
        window.location.reload();
    })
    .catch(error => {
        console.error('Error:', error);
    });
};