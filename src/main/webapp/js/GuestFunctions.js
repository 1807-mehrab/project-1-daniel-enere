function loadAvailableRooms(){
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        console.log(this.readyState);
        if (this.readyState == 4 && this.status == 200) {
            var issuesList = ``;
            var result = JSON.parse(xhr.responseText);
            var status = [];

            for(var i =0;i<result.length;i++){
            	
            	if(result[i].roomIsOccupied==0) {
            		status.push("Available");
            	} else {
            		status.push("Booked");
            	}
            	
            	 issuesList += `
                     <tr>
                     <td>`+result[i].roomGuestEmail+`</td><td>`+status[i]+`</td> <td>`+result[i].roomNumber+`</td>
                     </tr>
                     `;
            }
            console.log(result);
            document.getElementById('AvailableRooms').innerHTML = 
            	`
                  	<tbody>
                    `+issuesList+`
                    </tbody>
            `;
        }
    }
    xhr.open('POST', '/HotelVisit/RoomServlet');
    xhr.send();
}

function sendIssuesNow(){
    let xhr = new XMLHttpRequest();
    let issues = ``;
    xhr.onreadystatechange = function() {
        console.log(this.readyState);
        if (this.readyState == 4 && this.status == 200) {
            let issuesEmail = document.getElementById('issuesEmail').innerHTML;
            let issuesComment = document.getElementById('issuesComment').innerHTML;
            let issuesDate = document.getElementById('issuesDate').innerHTML;
        	
           issues += `+issuesEmail+`;
           issues += `+issuesComment+`;
           issues += `+issuesDate+`;
            	
        }
    }
    xhr.open('POST', '/HotelVisit/IssueServlet', true);
    xhr.send(JSON.stringify(issues));
}

function sendIssues() {
	
	let xhr = new XMLHttpRequest();
	let issueEmail;
	let ishComment;
	let ishDate;
	xhr.onreadystatechange = function() {
		if(this.readyState == 4) {
			if (this.status == 200) {
				 issueEmail = document.getElementById("issuesEmail");
				 ishComment = document.getElementById("issuesComment").innerHTML;
				 ishDate = document.getElementById("issuesDate").innerHTML;
				 console.log("issueEmail: " + issueEmail);
			}
		}
	}
	let issue = {guestEmail: issueEmail, issueComment: ishComment, issueDate: ishDate}
	console.log("Issue date: " + ishDate);
	xhr.open('POST', '/HotelVisit/IssueServlet', true);
	xhr.send(JSON.stringify(issue));
}
