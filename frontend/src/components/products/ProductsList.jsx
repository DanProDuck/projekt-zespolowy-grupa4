import {useEffect, useState} from "react";
import axios from "axios";
import {products as mockedProducts} from "../../assets/mockdata/products.js";
import Product from "./Product.jsx";
import {Card, Container, Pagination, SimpleGrid, Text} from "@mantine/core";
import {searchValue} from "../UI/Search.jsx";

const ProductsList = () => {
    let [products, setProducts] = useState([])
    const [totalNumber, setTotalNumber] = useState(0);
    const [activePage, setPage] = useState(1);
    const [searchBar, setSearchbar] = useState(searchValue)

    useEffect(() => {
        setSearchbar(searchValue)
    }, [searchValue])

    useEffect(() => {
        async function fetchProducts() {
            const response =
                await axios.get(`https://api-bookly.herokuapp.com/api/products?page=${activePage}&itemsPerPage=12`, {
                    headers: {
                        'Content-Type': 'application/json',
                        'Access-Control-Allow-Origin': '*'
                    }
                })
            setProducts(response.data)
        }

        async function fetchTotalNumberOfProducts() {
            const response = await axios.get("https://api-bookly.herokuapp.com/api/products/totalNumber", {
                headers: {
                    'Content-Type': 'application/json',
                    'Access-Control-Allow-Origin': '*'
                }
            })
            setTotalNumber(response.data)
        }

        fetchTotalNumberOfProducts();
        fetchProducts();
    }, [activePage])

    products = mockedProducts;

    console.log(products)
    const wrappedProducts = products.map((product) => [
        <Product
            key={product.id}
            product={product}
        />
    ])


    return (
        <Container fluid={true} px={4}>
            <SimpleGrid cols={4} spacing="xs" verticalSpacing="sm" breakpoints={[
                {maxWidth: 'xl', cols: 4, spacing: 'md'},
                {maxWidth: 'md', cols: 3, spacing: 'md'},
                {maxWidth: 'sm', cols: 2, spacing: 'sm'},
                {maxWidth: 'xs', cols: 1, spacing: 'sm'},
            ]}>
                <div><Text>{searchBar}</Text></div>
                {wrappedProducts}
            </SimpleGrid>
            <Pagination page={activePage} onChange={setPage} total={totalNumber / 12} disabled={totalNumber < 12} grow mt='xl'/>
        </Container>
    );
}

export default ProductsList;