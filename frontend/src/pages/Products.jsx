import Content from "../components/UI/Content.jsx";
import {Group, Select} from "@mantine/core";
import ProductsList from "../components/products/ProductsList.jsx";

const Products = () => {

    return (
        <>
            {/* <div>Top div with filtering options (sorting order and category)</div> 
            <div>List of filtered products </div> */}
            <Group>
                <Select
                    data={['Books', 'Not books', 'Something else']}
                    placeholder="Filtering options"
                    label="Select what items you want to display"
                />
            </Group>
            <Content>
                <ProductsList/>
            </Content>
        </>
    );
}

export default Products;