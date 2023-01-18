import { useContext, useState } from "react";
import {Paper, Text, Modal, Button} from "@mantine/core";
import CartModalProduct from "../products/CartModalProduct.jsx";
import {CartContext} from "../../context/CartContext.jsx";

const CartModal = () => {

    const cartCtx = useContext(CartContext);

    const items = cartCtx.items;

    return (

                    <Paper>
                        {items.length > 0 ?
                            <>
                                <p>Items in your cart:</p>
                                {items.map( (currentProduct, idx) => (
                                    <CartModalProduct key={idx} id={currentProduct.id} quantity={currentProduct.quantity} product={currentProduct}></CartModalProduct>
                                ))}

                                <h1>Total: {cartCtx.getTotalCost()}</h1>

                                <Button component = "a" href = "\success" variant="success">
                                    Purchase items!
                                </Button>
                            </>
                            :
                            <Text weight={600}
                                  variant="gradient"
                                  gradient={{ from: 'indigo', to: 'cyan', deg: 45 }}
                                  sx={{ fontFamily: 'Greycliff CF, sans-serif' }}
                                  ta="center"
                                  fz="xl"
                                  fw={700}
                            >
                                There are no items in shopping cart!
                            </Text>
                        }
                    </Paper>
    );
}

export default CartModal;