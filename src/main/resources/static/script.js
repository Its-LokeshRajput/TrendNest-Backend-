/**
 * 
 */
let requestMappingAt = 'seller'
let endPoint = 'getAllSellers'
let URL = `http://localhost:8080/${requestMappingAt}/${endPoint}`;
let data=null;
let resultDiv = document.querySelector(".results")
async function fetchingUsersData() {
    try {
        // let response = await fetch(URL, {
        //     method: "GET",
        //     mode: "cors" // Enable CORS requests
        // });

        let response = await fetch(URL)
        data = await response.json();
        // console.log(data);
        for(let d of data) {
            resultDiv.innerHTML += `
               UserName : ${d.sellerName} , Password : ${d.password}<br>
            `
        }
    } catch (error) {
        console.error("Error:", error);
    }
}
fetchingUsersData();