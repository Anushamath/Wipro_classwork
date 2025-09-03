// function wait(time)
// {

//const { forEach } = require("async");

//     // creating a promise that resolves after the provided time in milliseconds
//     return new Promise (resolve => setTimeout(resolve, time));

//     // before calling resolve() it will wait for the milliseconds you have defined which signals that the promise is complete


// }

// // async function tell JS that this function will use Promise and use the await keyword
// async function run()
// {

//     //It looks like a synchronous call even 
//     console.log("Started ... ");
//     await wait(1000); // it will wait for a second and then resolves
//     console.log("After 1000 ms it is stopped");
// }
// // await will pause the function unitl the Promise resolves 

// run();

// API 
function fetchProducts()
{
  
    return new Promise(resolve =>
        { 
                setTimeout(() => { resolve(["laptop" , "Mouse" , "speakers"]);

                                 }, 2000); // 2 seconds of delay in process or loading
        });
}

async function displayProducts()
{

    console.log("Fetching the products from the backend");
    const products = await fetchProducts(); //wait for the result or api call
    const productList = document.getElementById("products");
    productList.innerHTML = products.map(product=>product);

}


displayProducts();



document.getElementById("submit").addEventListener("click" , function()
{
    // using some test api(Json data)
    fetch("https://jsonplaceholder.typicode.com/users/1")
    .then(response => {
   
        if(!response.ok)
        {
            throw new Error("Some server error !");
        }
       // console.log(response.json());
        return response.json();
         })
    .then(data => {

       
        document.getElementById("output").innerHTML = `<h3> Post Title:</h3> ${data.username}
                                                       <h3> Post Body :</h3> ${data.email}`;
        

    })
    .catch(error => {document.getElementById("output").innerHTML = "Error: " + error.message;
    
    });
    
});
