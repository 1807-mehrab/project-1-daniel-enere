function loadAllRooms(){
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
    xhr.open('GET', '/HotelVisit/RoomServlet');
    xhr.send();
}

function loadGuests(){
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        console.log(this.readyState);
        if (this.readyState == 4 && this.status == 200) {
            var issuesList = ``;
            var result = JSON.parse(xhr.responseText);
            var status = [];

            for(var i =0;i<result.length;i++){
            	
            	if(result[i].isVIP==0) {
            		status.push("VIP");
            	} else {
            		status.push("Not VIP");
            	}
            	
            	 issuesList += `
                     <tr>
                     <td>`+result[i].guestName+`</td><td>`+result[i].guestAge+`</td> <td>`+result[i].guestEmail+`</td> <td>`+status[i]+`</td> 
                     </tr>
                     `;
            }
            console.log(result);
            document.getElementById('allGuests').innerHTML = 
            	`
                  	<tbody>
                    `+issuesList+`
                    </tbody>
            `;
        }
    }
    xhr.open('GET', '/HotelVisit/GuestServlet');
    xhr.send();
}

function loadIssues(){
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        console.log(this.readyState);
        if (this.readyState == 4 && this.status == 200) {
            var issuesList = ``;
            var result = JSON.parse(xhr.responseText);
            var date = [];
            var newDate;
            
            for(var i =0;i<result.length;i++){
            	
            	newDate = new Date(result[i].issueDate);
            	date.push(newDate);
            	 issuesList += `
                     <tr>
                     <td>`+result[i].guestEmail+`</td><td>`+result[i].issueComment+`</td> <td>`+date[i]+`</td>> 
                     </tr>
                     `;
            }
            console.log(result);
            document.getElementById('Issues').innerHTML = 
            	`
                  	<tbody>
                    `+issuesList+`
                    </tbody>
            `;
        }
    }
    xhr.open('GET', '/HotelVisit/IssueServlet');
    xhr.send();
}

function loadReservations(){
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        console.log(this.readyState);
        if (this.readyState == 4 && this.status == 200) {
            var issuesList = ``;
            var result = JSON.parse(xhr.responseText);
            var date = [];
            var date2 = [];
            
            var CheckinDate;
            var ReserveDate;
            for(var i =0;i<result.length;i++){
            	
            	CheckinDate = new Date(result[i].dateCheckin);
            	ReserveDate = new Date(result[i].dateReserved);
            	date.push(ReserveDate);
            	date2.push(CheckinDate);
            	
            	 issuesList += `
                     <tr>
                     <td>`+result[i].guestEmail+`</td><td>`+result[i].hostName+`</td> <td>`+result[i].roomNumber+`</td>  <td>`+date[i]+`</td> <td>`+date2[i]+`</td> 
                     </tr>
                     `;
            }
            console.log(result);
            document.getElementById('Reservations').innerHTML = 
            	`
                  	<tbody>
                    `+issuesList+`
                    </tbody>
            `;
        }
    }
    xhr.open('GET', '/HotelVisit/ReservationServlet');
    xhr.send();
}
