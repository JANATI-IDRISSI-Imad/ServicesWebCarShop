# ServicesWebCarShop
url=https://carsho.herokuapp.com
_________________User___________________________

/User/get/{id} ex : /User/get/1
/User/add
/User/getByEmail/{email}
/User/getUserByName/{name}

_________________Cart___________________________

/Cart/getByEmailUser/{email}
/Cart/gatTotalCart/{id}
/addCarToCart/{email}/{id_Car}
/deleteCarFromCart/{email}/{id_Car}
/clearCart/{email}
/validateCart/{email}


_________________Car_____________________________

/Car/get/{id}
/Car/getByName/{name}
/Car/getByModel/{model}
/Car/getByAdress/{adress}
/Car/getAllCars
/Car/add
