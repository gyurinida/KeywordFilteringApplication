const WK = "29bead8ce7468ae60d66c7db7ec4fc63";
function locSuccess(pos) {
    console.log(pos);
    const latitude = pos.coords.latitude;
    const longitude = pos.coords.longitude;
    getWeather(latitude, longitude);
};

function locError(err) {
    console.warn('ERROR(' + err.code + '): ' + err.message);
};

function getWeather(lat, lon) {
    fetch(`https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${lon}&appid=${WK}&units=metric`)
        .then(res => res.json())
        .then(data => {
            const temp = data.main.temp;
            const weathers = data.weather[data.weather.length-1];
            console.log(temp);
            console.log(weathers);
        })
}

navigator.geolocation.getCurrentPosition(locSuccess, locError);