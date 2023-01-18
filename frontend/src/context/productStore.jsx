import {useContext} from "react";
import {CartContext} from "./CartContext.jsx";

const cartCtx = useContext(CartContext)
const productsArray = cartCtx.items;

export function getProductData(id) {
    let productData = productsArray.find(product => product.id === id);

    if (productData === undefined) {
        console.log("Product data does not exist for ID: " + id);
        return undefined;
    }

    return productData;
}
