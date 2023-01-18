import {useParams} from "react-router-dom";
import {Box, Container, Group, Image} from "@mantine/core";
import {useEffect} from "react";
import axios from "axios";

const SingleProduct = () => {
    const params = useParams();

    let product;

    useEffect( () => {
        async function fetchProduct() {
            const resp = await axios.get(`http://localhost:8082/api/products/${params.id}`)
            return resp.data;
        }

        if (params.id) {
            product = fetchProduct()
        } 
        else {

        }
    }, [])

    return (
        <Container>
            <Group>
                <Image /> {}
                <Group />
            </Group>
            <Box /> 
        </Container>
    );
}

export default SingleProduct;
