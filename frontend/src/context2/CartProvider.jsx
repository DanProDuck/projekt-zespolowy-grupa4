import CartContext from "./cart-context.jsx";
import {useReducer} from "react";

const initialCartState = {
    items: [],
    totalAmount: 0
}

const cartReducer = (state, action) => {
    switch (action.type) {
        case 'ADD':
            // if (userCtx.subscription === 'MONTHLY' {items.length?})
            const updatedItems = state.items.concat(action.item)
            const updatedTotalAmount = state.totalAmount + action.item.buyPrice * action.item.quantity //or amount

            return {
                items: updatedItems,
                totalAmount: updatedTotalAmount
            }
        case 'REMOVE':

        default:
            //throw new Error()??
    }
}

const CartProvider = (props) => {
    const [cartState, dispatchCartAction] = useReducer(cartReducer, initialCartState);


    const addItemToCart = item => {
        dispatchCartAction({type: 'ADD', item: item})
    }

    const removeItemFromCart = id => {

    }

    //we can use localStorage to persist data, or sessionStorage to save it session wise
    const cartContext = {
        items: cartState.items,
        totalAmount: cartState.totalAmount,
        addItem: addItemToCart,
        removeItem: removeItemFromCart
    }

    return (
        <CartContext.Provider value={cartContext}>
            {props.children}
        </CartContext.Provider>
    );
}

export default CartProvider;