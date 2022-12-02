//import '../CardStyles.css'
import {Col, Row, Form, Button} from 'react-bootstrap'
import { CartContext, cartProduct } from '../CartContext';
import { useContext } from 'react';
import * as React from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Typography from '@mui/material/Typography';
import { CardActionArea } from '@mui/material';


function ProductCard(props) { // props.product is the product we are selling
    const product = props.product;
    const cart = useContext(CartContext);
    const productQuantity = cart.getProductQuantity(product.id);
    console.log(cart.items);
    return (

        <Card sx={{ maxWidth: 345 }}>
        <CardActionArea>
          <CardMedia
            component="img" 
            height="240"
            //image="mcbooks.png"
            //alt = {{product.id}}
          />
          <CardContent>
            <Typography gutterBottom variant="h5" component="div">
            {product.title}
            </Typography>
            <Typography variant="body2" color="text.secondary">
            ${product.price} / ${product.borrowprice}               
            </Typography>
            { productQuantity > 0 ?
                    <>
                        <Button sm="6" onClick={() => cart.addOneToCart(product.id)} className="mx-2">+</Button>
                        <Button sm="6" onClick={() => cart.removeOneFromCart(product.id)} className="mx-2">-</Button>
                        <Button variant="danger" onClick={() => cart.deleteFromCart(product.id)} className="my-2">Remove from cart</Button>
                    </>
                    :
                    <Button variant="primary" onClick={() => cart.addOneToCart(product.id)}>Add To Cart</Button>
                }
          </CardContent>
        </CardActionArea>
      </Card>
    );
}

export default ProductCard;