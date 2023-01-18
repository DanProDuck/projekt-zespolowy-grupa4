import { Button } from '@mantine/core';
import { useContext } from "react";
import {CartContext} from "../../context/CartContext.jsx"

function CartModalProduct(props) {
    // const cart = useContext(CartContext);
    // const id = props.id;
    // const quantity = props.quantity;
    // const productData = props.product;
    const cartCtx = useContext(CartContext);
    const product = cartCtx.items[props.id];

    return (
        <>
            <h3>{product.title}</h3>
            <p>{product.quantity} total</p>
            <p>${ (product.quantity * product.buyPrice).toFixed(2) }</p>
            <Button size="sm" onClick={() => cartCtx.deleteFromCart(product.id)}>Remove</Button>
            <hr></hr>
        </>
    )
}

export default CartModalProduct;