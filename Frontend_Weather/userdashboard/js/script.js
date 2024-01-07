function updateSearchBar() {
    let dropdown = document.getElementById("searchDropdown");
    let searchBox = document.getElementById("searchBox");
   
    searchBox.style.display = "none";
    searchBox.firstChild.value = dropdown.value;
   }
   
   function handleKeyPress(event) {
    if (event.key === "Enter") {
       showWeatherData();
    }
   }
   
   function showWeatherData() {
    // Get the search query
    let searchQuery = document.getElementById("searchBox").firstChild.value;
   
    // Call your API here with the search query and get the weather data
   
    // For now, just update the weather box data
    document.getElementById("weatherBox1").lastChild.textContent = "22°C";
    document.getElementById("weatherBox2").lastChild.textContent = "60%";
    document.getElementById("weatherBox3").lastChild.textContent = "2 m/s";
    document.getElementById("weatherBox4").lastChild.textContent = "50%";
   }