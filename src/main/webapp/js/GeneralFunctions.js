function logout() {
			let xhr = new XMLHttpRequest();
			
			xhr.onreadystatechange = function() {
				if(this.readyState == 4) {
					if (this.status == 200) {
						document.getElementById("body").innerHTML = xhr.response;
					} else {
						console.log("error");
					}
				}
			}
			xhr.open('POST', '/HotelVisit/Logout');
			xhr.send();
		}