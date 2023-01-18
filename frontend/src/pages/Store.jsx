import Hero from "../components/UI/Hero";
import Content from "../components/UI/Content";
import {useScrollIntoView} from '@mantine/hooks';
import ProductsList from "../components/products/ProductsList.jsx";

const Store = () => {
    const {scrollIntoView, targetRef} = useScrollIntoView({
        offset: 65,
        easing: t => t === 1 ? 1 : 1 - Math.pow(2, -10 * t)
    });

    return (
        <>
            <Hero scrollFunc={scrollIntoView}/>
            <Content ref={targetRef}>
                <ProductsList/>
            </Content>
        </>
    )
}

export default Store;