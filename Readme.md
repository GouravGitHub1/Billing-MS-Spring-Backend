I have created a billing microservice and deployed it on Heroku. Code is present on GitHub and the link is provided below. 

1. Heroku link => https://hacker-bills.herokuapp.com
2. GitHub link => https://github.com/GouravGitHub1/Billing-MS-Spring-Backend
3. Database: MongoDB is used for storing the data. I have used free mongo atlas to host MongoDB Backend.

APIs=>

1.  https://hacker-bills.herokuapp.com/bills/add (POST API)

Explanation: This API is used to add new bills in the database with a specific due date. for each bill, the user has to provide billed to person's name, billed price, and tax on the bill. Other fields i.e. bill number, billed date, the total price will be calculated accordingly and saved.

Body example: 
{
	"bills":[
		{
			"billedTo": "DEF",
			"billedPrice": 1000,
			"taxOnBill": 5
		},
		{
			"billedTo": "ABC",
			"billedPrice": 100,
			"taxOnBill": 5
		},
		{
			"billedTo": "GHI",
			"billedPrice": 10000,
			"taxOnBill": 5
		}
		
		],
	"dueDate":"27-11-21"
}

Response: Bills added successfully.





2. https://hacker-bills.herokuapp.com/bills (GET API)

Explanation: This API is used to fetch all the bills stored in the database in JSON format.

Response: [
    {
        "_id": "6191f82db53b8cd7563ab377",
        "billNumber": 2,
        "billedTo": "Mark c",
        "billedDate": "2021-01-02T00:00:00.000+00:00",
        "billedPrice": 100,
        "taxOnBill": 50,
        "totalPrice": 150,
        "dueDate": "2021-01-10T00:00:00.000+00:00"
    },
    {
        "_id": "6192449d8af6f992920e31ec",
        "billNumber": 3,
        "billedTo": "Will M",
        "billedDate": "2021-01-01T00:00:00.000+00:00",
        "billedPrice": 100,
        "taxOnBill": 50,
        "totalPrice": 150,
        "dueDate": "2021-11-26T00:00:00.000+00:00"
    }
]




3. https://hacker-bills.herokuapp.com/bills/{billNumber} (GET API)

Explanation: This API is used to fetch a specific bill by providing bill number stored in the database in JSON format.

Example: https://hacker-bills.herokuapp.com/bills/3

Response: {
    "_id": "6192449d8af6f992920e31ec",
    "billNumber": 3,
    "billedTo": "Will M",
    "billedDate": "2021-01-01T00:00:00.000+00:00",
    "billedPrice": 100,
    "taxOnBill": 50,
    "totalPrice": 150,
    "dueDate": "2021-11-26T00:00:00.000+00:00"
}




4. https://hacker-bills.herokuapp.com/bills/due/{dueDate} (GET API)

Explanation: This API is used to fetch bills with the provided due date in JSON list format.

Example: https://hacker-bills.herokuapp.com/bills/due/28-11-21

Response: [
    {
        "_id": "61926fba1f144c260a53fa6b",
        "billNumber": 9,
        "billedTo": "test user",
        "billedDate": "2021-11-15T14:33:30.116+00:00",
        "billedPrice": 200,
        "taxOnBill": 15,
        "totalPrice": 230,
        "dueDate": "2021-11-28T00:00:00.000+00:00"
    }
]


