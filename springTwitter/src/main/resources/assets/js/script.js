function TweetInfo(responseData){
    timelineDiv = document.getElementById('tweet-container');
    timelineDiv.classList.add("timelineDiv");
    // to clear the div block
console.log(responseData)
    while(timelineDiv.firstChild){
        timelineDiv.removeChild(timelineDiv.firstChild);
    }

    for (let index = 0; index < responseData.length; index++) {
        let tweetInfo = document.createElement('div')
        tweetInfo.classList.add('block-' + index%2,'blocks');
        let text = "<div class='right'><span class='dp'> <img class='profile' src='" + responseData[index].user.profileImageURL + "'></span>";
        text+="<span class='uname'>" + responseData[index].user.name + "</span></div>";



        text+=" <div class='left'><span class='date'>" + new Date(responseData[index].createdAt).toLocaleString('en', {
            month: 'long',
            day: 'numeric',
            year: 'numeric',
        }); + "</span>";

        console.log(responseData[index].user.url);

        text+="<p></p><span class='status'><a href=" + responseData[index].user.url + ">"+ responseData[index].text + "</a></span></div>";
        tweetInfo.innerHTML = text;
        document.getElementById("tweet-container").appendChild(tweetInfo);
    }
}

function viewTimeline(){
    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'http://localhost:8080/api/1.0/twitter/timeline');
    xhr.send();
    xhr.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200){
            TweetInfo(JSON.parse(this.responseText));

        }
    };

}
