import {
    Badge,
    Image,
    Button,
    Card,
    Center,
    SimpleGrid,
    Text,
    Anchor, 
    Rating, 
    AspectRatio, 
    Stack
} from "@mantine/core";
import { useContext } from 'react';
import {IconBookmark} from '@tabler/icons';
import {CartContext} from "../../context/CartContext.jsx";

const Product = (props) => {

    const productId = props.product.id; 

    let currentDate = new Date();
    let anotherDate = new Date(props.product.dateOfIssue);

    const cartCtx = useContext(CartContext);
    
    return (
        <Card shadow="sm" p="lg" radius="md" withBorder>
            <Card.Section component="a" href={`/product/${props.product.id}`}>
                
                <AspectRatio ratio={1.35}>
                    <Image
                        src={props.product.pictureUrl}
                        height={160}
                        alt="Product's picture"
                    />
                </AspectRatio>
            </Card.Section>

            <Stack justify="flex-end">
                <Text lh={1} weight={500}>{props.product.title}</Text>
                <Text lh={1} fz={14} mt={-8} color="dimmed">{props.product.authorID.name} {props.product.authorID.surname}</Text>
                <SimpleGrid cols={2}>
                    <Center>
                        <Rating readOnly value={props.product.rating} fractions={10}/>
                    </Center>
                    <Text ta="right" mx={15} fz={18}>${props.product.buyPrice}</Text>
                </SimpleGrid>

                {currentDate < anotherDate && <Badge color="teal.6" variant="light">
                    Available soon
                </Badge>}
                <SimpleGrid cols={2}>
                    {props.product.onSale && <Badge color="pink" variant="light">
                        On Sale
                    </Badge>}
                    {props.product.forRent && <Badge color="yellow.6" variant="light">
                        Borrow now
                    </Badge>}
                </SimpleGrid>

                <Text size="sm" color="dimmed" lineClamp={2}>
                    {props.product.description}
                </Text>
                <Center mt={500} sx={{bottom: 0, marginTop: "auto"}}>
                    <Button onClick={() => cartCtx.addOneToCart(props.product.id)} variant="filled" color="blue.6" fullWidth radius="md">
                        Add to cart
                    </Button>
                    <Center ml={20}>
                        <Anchor component='button' sx={{textDecoration: 'none', lineHeight: 1}}>
                            <IconBookmark style={{strokeWidth: 2.25, height: 26, width: 26}}/>
                        </Anchor>
                    </Center>
                </Center>
            </Stack>
        </Card>
    );
}

export default Product;